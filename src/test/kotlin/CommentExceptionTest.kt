import attachments.Audio
import attachments.AudioAttachment
import org.junit.Test

import org.junit.Assert.*

class CommentExceptionTest {

    @Test
    fun shouldGoOn() {
        //arrange
        val service = WallService()
        val postTest: Post = Post(
            0, 123, 321, 456, 10012022, "my test text post", 654, 789,
            987, Comment(2, 0,1, 12102022, "My Comment", true), "no copyright here",
            Likes(1, false, false, false), Reposts(1, true), Views(1),
            "Great Post", AudioAttachment(Audio(1,123, "Hey", "Ba-da-boom", 163, 11122022)),100, false, false, false, false, false,
            false, 123
        )
        val comment: Comment = Comment(0, 1, 2, 31012022,"Comment", true)

        //act
        service.add(postTest)
        val makeComment = service.createComment(comment)

        //assert
        assertEquals(makeComment, comment)
    }

    @Test(expected = PostNotFoundException::class)
    fun shouldThrow() {
        //arrange
        val service = WallService()
        val postTest: Post = Post(
            32, 123, 321, 456, 10012022, "my test text post", 654, 789,
            987, Comment(2, 0,1, 12102022, "My Comment", true), "no copyright here",
            Likes(1, false, false, false), Reposts(1, true), Views(1),
            "Great Post", AudioAttachment(Audio(1,123, "Hey", "Ba-da-boom", 163, 11122022)),100, false, false, false, false, false,
            false, 123
        )
        val comment: Comment = Comment(2, 36, 2, 31012022,"Comment", true)

        //act
        service.add(postTest)
        service.createComment(comment)
    }
}