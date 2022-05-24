import org.junit.Test

import org.junit.Assert.*

class NoteServiceTest {

    @Test
    fun add() {
        //arrange
        val noteTest = Note(0, "Note 1", "Note Text", true)
        val noteService = NoteService()

        //act
        val result = noteService.add(noteTest)
        val noteId = 1

        //assert
        assertEquals(noteId, result)
    }

    @Test
    fun delete() {
        //arrange
        val noteService = NoteService()
        val noteTest = Note(0, "Note 1", "Note Text", true)
        val noteTest2 = Note(0, "Note 2", "Note Text 2", true)

        //act
        noteService.add(noteTest)
        noteService.add(noteTest2)
        noteService.delete(1)

        //assert
        assertFalse(noteService.edit(noteTest))
    }

    @Test(expected = PostNotFoundException::class)
    fun noDelete() {
        //arrange
        val noteService = NoteService()
        val noteTest = Note(0, "Note 1", "Note Text", true)

        //act
        noteService.add(noteTest)
        noteService.delete(5)
    }

    @Test
    fun edit() {
        //arrange
        val noteService = NoteService()
        val noteTest = Note(0, "Note 1", "Note Text", true)

        //act
        noteService.add(noteTest)
        val result = noteService.edit(Note(1, "New Note 1", "New Note Text", true))

        //assert
        assertTrue(result)
    }

    @Test
    fun noEdit() {
        //arrange
        val noteService = NoteService()
        val noteTest = Note(0, "Note 1", "Note Text", true)

        //act
        noteService.add(noteTest)
        val result = noteService.edit(Note(5, "New Note 1", "New Note Text", true))

        //assert
        assertFalse(result)
    }

    @Test
    fun getById() {
        //arrange
        val noteService = NoteService()
        val noteTest = Note(1, "Note 1", "Note Text", true)

        //act
        noteService.add(noteTest)
        val noteTestNew = Note(2, "Note 1", "Note Text", true)

        //assert
        assertEquals(noteTestNew, noteService.getById(2))
    }

    @Test(expected = PostNotFoundException::class)
    fun noGetNoteById() {
        //arrange
        val noteService = NoteService()
        val noteTest = Note(1, "Note 1", "Note Text", true)

        //act
        noteService.add(noteTest)
        noteService.getById(8)
    }

    @Test
    fun restore() {
        //arrange
        val noteService = NoteService()
        val noteTest = Note(0, "Note 1", "Note Text", true)

        //act
        noteService.add(noteTest)
        noteService.delete(1)
        val result = noteService.restore(1)

            //assert
        assertEquals(result, Note(1, "Note 1", "Note Text", true))
    }

    @Test(expected = PostNotFoundException::class)
    fun noRestore() {
        //arrange
        val noteService = NoteService()
        val noteTest = Note(0, "Note 1", "Note Text", true)

        //act
        noteService.add(noteTest)
        noteService.delete(1)
        noteService.restore(6)
    }
}