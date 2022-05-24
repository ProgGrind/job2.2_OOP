import org.junit.Test

import org.junit.Assert.*

class CommentServiceTest {

    @Test
    fun add() {
        //arrange
        val commentTest = Comment(0, 1,1, 12102022, "My Comment", true)
        val commentService = CommentService()

        //act
        val result = commentService.add(commentTest)
        val noteId = 1

        //assert
        assertEquals(noteId, result)
    }

    @Test
    fun delete() {
        //arrange
        val commentService = CommentService()
        val commentTest = Comment(0, 1,1, 12102022, "My Comment", true)
        val commentTest2 = Comment(0, 1,1, 12102022, "My Comment", true)

        //act
        commentService.add(commentTest)
        commentService.add(commentTest2)
        commentService.delete(1)

        //assert
        assertFalse(commentService.edit(commentTest))
    }

    @Test(expected = PostNotFoundException::class)
    fun noDelete() {
        //arrange
        val commentService = CommentService()
        val commentTest = Comment(0, 1,1, 12102022, "My Comment", true)

        //act
        commentService.add(commentTest)
        commentService.delete(5)
    }

    @Test
    fun edit() {
        //arrange
        val commentService = CommentService()
        val commentTest = Comment(0, 1,1, 12102022, "My Comment", true)

        //act
        commentService.add(commentTest)
        val result = commentService.edit(Comment(1, 1,1, 12102022, "My Comment", true))

        //assert
        assertTrue(result)
    }

    @Test
    fun noEdit() {
        //arrange
        val commentService = CommentService()
        val commentTest = Comment(0, 1,1, 12102022, "My Comment", true)

        //act
        commentService.add(commentTest)
        val result = commentService.edit(Comment(7, 1,1, 12102022, "My Comment", true))

        //assert
        assertFalse(result)
    }

    @Test
    fun getById() {
        //arrange
        val commentService = CommentService()
        val commentTest = Comment(1, 1,1, 12102022, "My Comment", true)

        //act
        commentService.add(commentTest)
        val commentTestNew = Comment(2, 1,1, 12102022, "My Comment", true)

        //assert
        assertEquals(commentTestNew, commentService.getById(2))
    }

    @Test(expected = PostNotFoundException::class)
    fun noGetNoteById() {
        //arrange
        val commentService = CommentService()
        val commentTest = Comment(1, 1,1, 12102022, "My Comment", true)

        //act
        commentService.add(commentTest)
        commentService.getById(8)
    }

    @Test
    fun restore() {
        //arrange
        val commentService = CommentService()
        val commentTest = Comment(0, 1,1, 12102022, "My Comment", true)

        //act
        commentService.add(commentTest)
        commentService.delete(1)
        val result = commentService.restore(1)

        //assert
        assertEquals(result, Comment(1, 1,1, 12102022, "My Comment", true))
    }

    @Test(expected = PostNotFoundException::class)
    fun noRestore() {
        //arrange
        val commentService = CommentService()
        val commentTest = Comment(0, 1,1, 12102022, "My Comment", true)

        //act
        commentService.add(commentTest)
        commentService.delete(1)
        commentService.restore(6)
    }
}