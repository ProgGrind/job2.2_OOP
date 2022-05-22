import org.junit.Test

import org.junit.Assert.*

class NoteServiceTest {


    @Test
    fun add() {
        //arrange
        val noteService = NoteService()
        val comment = Comment(2, 0,1, 12102022, "My Comment", true)
        val comments = mutableListOf<Comment>(comment)
        val noteTest = Note(0, "Note 1", "Note Text", comments)

        //act
        val result = noteService.add(noteTest)
        val noteId = 1

        //assert
        assertEquals(noteId, result.id)
    }

    @Test
    fun createComment() {
        //arrange
        val noteService = NoteService()
        val comment = Comment(2, 1,1, 12102022, "My Comment", true)
        val comment2 = Comment(3, 1,1, 12102022, "My Comment", true)
        val comments = mutableListOf<Comment>(comment)
        val noteTest = Note(0, "Note 1", "Note Text", comments)


        //act
        noteService.add(noteTest)
        val result = noteService.createComment(comment2)
        val commentId = 4

        //assert
        assertEquals(commentId, result.id)
    }

    @Test
    fun delete() {
        //arrange
        val noteService = NoteService()
        val comments = mutableListOf<Comment>(Comment(2, 1,1, 12102022, "My Comment", true))
        val comments2 = mutableListOf<Comment>(Comment(3, 2,1, 12102022, "My Comment", true))
        val noteTest = Note(0, "Note 1", "Note Text", comments)
        val noteTest2 = Note(0, "Note 2", "Note Text 2", comments2)

        //act
        noteService.add(noteTest)
        noteService.add(noteTest2)
        val result = noteService.delete(Note(1, "Note 1", "Note Text", comments))

        //assert
        assertTrue(result)
    }

    @Test
    fun noDelete() {
        //arrange
        val noteService = NoteService()
        val comments = mutableListOf<Comment>(Comment(2, 1,1, 12102022, "My Comment", true))
        val noteTest = Note(0, "Note 1", "Note Text", comments)

        //act
        noteService.add(noteTest)
        val result = noteService.delete(Note(id = 6, "Note 1", "Note Text", comments))

        //assert
        assertFalse(result)
    }

    @Test
    fun deleteComment() {
        //arrange
        val noteService = NoteService()
        val comment = Comment(2, 1,1, 12102022, "My Comment", true)
        val comment2 = Comment(3, 1,1, 12102022, "My Comment", true)
        val comments = mutableListOf<Comment>(comment)
        val comments2 = mutableListOf<Comment>(comment2)
        val noteTest = Note(0, "Note 1", "Note Text", comments)
        val noteTest2 = Note(0, "Note 2", "Note Text 2", comments2)

        //act
        noteService.add(noteTest)
        noteService.add(noteTest2)
        val result = noteService.deleteComment(Comment(id = 3, 1,1, 12102022, "My Comment", true))

        //assert
        assertTrue(result)
    }

    @Test
    fun noDeleteComment() {
        //arrange
        val noteService = NoteService()
        val comment = Comment(2, 1,1, 12102022, "My Comment", true)
        val comment2 = Comment(3, 1,1, 12102022, "My Comment", true)
        val comments = mutableListOf<Comment>(comment)
        val comments2 = mutableListOf<Comment>(comment2)
        val noteTest = Note(0, "Note 1", "Note Text", comments)
        val noteTest2 = Note(0, "Note 2", "Note Text 2", comments2)

        //act
        noteService.add(noteTest)
        noteService.add(noteTest2)
        val result = noteService.deleteComment(Comment(id = 8, 1,1, 12102022, "My Comment", true))

        //assert
        assertFalse(result)
    }

    @Test
    fun edit() {
        //arrange
        val noteService = NoteService()
        val comments = mutableListOf<Comment>(Comment(2, 1,1, 12102022, "My Comment", true))
        val noteTest = Note(0, "Note 1", "Note Text", comments)

        //act
        noteService.add(noteTest)
        val result = noteService.edit(Note(1, "New Note 1", "New Note Text", comments))

        //assert
        assertTrue(result)
    }

    @Test
    fun editComment() {
        //arrange
        val noteService = NoteService()
        val comment = Comment(2, 1,1, 12102022, "My Comment", true)
        val comments = mutableListOf<Comment>(comment)
        val noteTest = Note(0, "Note 1", "Note Text", comments)

        //act
        noteService.add(noteTest)
        val result = noteService.editComment( Note(0, "Note 1", "Note Text", comments),
            Comment(2, 1,1, 12102022, "My Comment", true))

        //assert
        assertTrue(result)
    }

    @Test
    fun noEditComment() {
        //arrange
        val noteService = NoteService()
        val comment = Comment(2, 1,1, 12102022, "My Comment", true)
        val comments = mutableListOf<Comment>(comment)
        val noteTest = Note(0, "Note 1", "Note Text", comments)

        //act
        noteService.add(noteTest)
        val result = noteService.editComment( Note(6, "Note 1", "Note Text", comments),
            Comment(5, 1,1, 12102022, "My Comment", true))

        //assert
        assertFalse(result)
    }


    @Test
    fun getNotesList() {
        //arrange
        val noteService = NoteService()
        val comment = Comment(2, 2,1, 12102022, "My Comment", true)
        val comments = mutableListOf<Comment>(comment)
        val noteTest = Note(1, "Note 1", "Note Text", comments)

        //act
        noteService.add(noteTest)
        val list = mutableListOf(Note(2, "Note 1", "Note Text", comments))

        //assert
        assertEquals(list, noteService.getNotesList())
    }

    @Test
    fun getNoteById() {
        //arrange
        val noteService = NoteService()
        val comment = Comment(2, 1,1, 12102022, "My Comment", true)
        val comments = mutableListOf<Comment>(comment)
        val noteTest = Note(0, "Note 1", "Note Text", comments)

        //act
        val note = noteService.add(noteTest)
        val result = noteService.getNoteById(1)

        //assert
        assertEquals(result, note)
    }

    @Test(expected = PostNotFoundException::class)
    fun noGetNoteById() {
        //arrange
        val noteService = NoteService()
        val comment = Comment(2, 1,1, 12102022, "My Comment", true)
        val comments = mutableListOf<Comment>(comment)
        val noteTest = Note(0, "Note 1", "Note Text", comments)

        //act
        val note = noteService.add(noteTest)
        noteService.getNoteById(8)
    }

    @Test
    fun getCommentsList() {
        //arrange
        val noteService = NoteService()
        val comment = Comment(2, 2,1, 12102022, "My Comment", true)
        val comments = mutableListOf<Comment>(comment)
        val noteTest = Note(1, "Note 1", "Note Text", comments)

        //act
        val note = noteService.add(noteTest)

        //assert
        assertEquals(comments, noteService.getCommentsList(note))
    }


    @Test
    fun restoreComment() {
        //arrange
        val noteService = NoteService()
        val comment = Comment(2, 1,1, 12102022, "My Comment", true)
        val comments = mutableListOf<Comment>(comment)
        val noteTest = Note(0, "Note 1", "Note Text", comments)

        //act
        noteService.add(noteTest)
        noteService.deleteComment(comment)
        val result = noteService.restoreComment(comment)

            //assert
        assertEquals(result, Comment(2, 1,1, 12102022, "My Comment", true))
    }

    @Test(expected = PostNotFoundException::class)
    fun noRestoreComment() {
        //arrange
        val noteService = NoteService()
        val comment = Comment(2, 1,1, 12102022, "My Comment", true)
        val comments = mutableListOf<Comment>(comment)
        val noteTest = Note(0, "Note 1", "Note Text", comments)

        //act
        noteService.add(noteTest)
        noteService.deleteComment(comment)
        val result = noteService.restoreComment(Comment(9, 1,1, 12102022, "My Comment", true))
    }
}