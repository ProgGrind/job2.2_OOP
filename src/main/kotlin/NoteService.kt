class NoteService() : CrudService<Note> {

    override val entities = mutableListOf<Note>()
    private val deleting = mutableListOf<Note>()

    override fun add(note: Note): Int {
        val noteNewId = note.copy(id = note.id + 1)
        entities.add(noteNewId)
        return noteNewId.id
    }

    override fun delete(id: Int) {
        for (note in entities) {
            if (note.id == id && note.existing) {
                deleting.add(note.copy(id = note.id, existing = false))
                entities.remove(note)
                return
            }
        }
        throw PostNotFoundException("Note not found!")
    }

    override fun edit(note: Note): Boolean {
        var ed = false
        for ((index, element) in entities.withIndex()) {
            if (element.id == note.id && note.existing) {
                entities[index] = element.copy(id = note.id)
                ed = true
            }
        }
        return ed
    }

    override fun getById(id: Int): Note {
        for (note in entities) {
            if (note.id == id && note.existing)
                return note
        }
        throw PostNotFoundException("Note not found!")
    }

    override fun restore(id: Int): Note {
        for (note in deleting) {
            if (note.id == id && !note.existing) {
                deleting.remove(note)
                val restoredNote = note.copy(id = note.id, existing = true)
                entities.add(restoredNote)
                return restoredNote
            }
        }
        throw PostNotFoundException("Wasn't deleted!")
    }
}