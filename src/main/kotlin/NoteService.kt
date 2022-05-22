class NoteService {
    val notes = mutableListOf<Note>()

    fun add(note: Note): Note {
        val noteNewId = note.copy(id = note.id + 1)
        notes += noteNewId
        return notes.last()
    }

    fun createComment(comment: Comment): Comment {
        for (note in notes) {
            if (note.id == comment.postId) {
                val commentNewId = comment.copy(id = comment.id + 1)
                note.comments += commentNewId
                return commentNewId
            }
        }
        throw PostNotFoundException("Note not found!")
    }

    fun delete(note: Note): Boolean {
        var del = false
        for (element in notes) {
            if (element.id == note.id) {
                notes.remove(note)
                del = true
            }
        }
        return del
    }

    fun deleteComment(comment: Comment): Boolean {
        for (note in notes) {
            for ((index, element) in note.comments.withIndex()) {
                if (element.id == comment.id) {
                    note.comments[index].existing = false
                    return true
                }
            }
        }
        return false
    }

    fun edit(note: Note): Boolean {
        var ed = false
        for ((index, element) in notes.withIndex()) {
            if (element.id == note.id) {
                notes[index] = element.copy(
                    id = note.id,
                    title = note.title,
                    text = note.text,
                    comments = note.comments,
                )
                ed = true
            }
        }
        return ed
    }

    fun editComment(note: Note, comment: Comment): Boolean {
        var ed = false
        for ((index, element) in note.comments.withIndex()) {
            if (element.id == comment.id) {
                note.comments[index] = element.copy(
                    id = comment.id,
                    postId = comment.postId,
                    fromId = comment.fromId,
                    date = comment.date,
                    text = comment.text,
                    existing = comment.existing
                )
                ed = true
            }
        }
        return ed
    }

    fun getNotesList(): MutableList<Note> {
        return notes
    }

    fun getNoteById(noteId: Int): Note {
        for (note in notes) {
            if (note.id == noteId)
                return note
        }
        throw PostNotFoundException("Note not found!")
    }

    fun getCommentsList(note: Note): MutableList<Comment> {
        for (element in notes) {
            if (element.id == note.id) {
                return note.comments
            }
        }
        throw PostNotFoundException("There are no comments!")
    }

    fun restoreComment(comment: Comment): Comment {
        for (note in notes) {
            for ((index, element) in note.comments.withIndex()) {
                if (element.id == comment.id) {
                    note.comments[index].existing = true
                    return comment
                }
            }
        }
        throw PostNotFoundException("Comment wasn't deleted!")
    }
}