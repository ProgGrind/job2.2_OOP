class CommentService() : CrudService<Comment> {

    override val entities = mutableListOf<Comment>()
    private val deleting = mutableListOf<Comment>()

    override fun add(comment: Comment): Int {
        val commentNewId = comment.copy(id = comment.id + 1)
        entities.add(commentNewId)
        return commentNewId.id
    }

    override fun delete(id: Int) {
        for (comment in entities) {
            if (comment.id == id && comment.existing) {
                deleting.add(comment.copy(id = comment.id, existing = false))
                entities.remove(comment)
                return
            }
        }
        throw PostNotFoundException("Comment not found!")
    }

    override fun edit(comment: Comment): Boolean {
        var ed = false
        for ((index, element) in this.entities.withIndex()) {
            if (element.id == comment.id && comment.existing) {
                this.entities[index] = element.copy(id = comment.id)
                ed = true
            }
        }
        return ed
    }

    override fun getById(id: Int): Comment {
        for (comment in entities) {
            if (comment.id == id && comment.existing)
                return comment
        }
        throw PostNotFoundException("Note not found!")
    }

    override fun restore(id: Int): Comment {
        for (comment in deleting) {
            if (comment.id == id && !comment.existing) {
                deleting.remove(comment)
                val restoredComment = comment.copy(id = comment.id, existing = true)
                entities.add(restoredComment)
                return restoredComment
            }
        }
        throw PostNotFoundException("Wasn't deleted!")
    }
}