import attachments.Audio
import attachments.AudioAttachment
import org.junit.Test

import org.junit.Assert.*
import report.*

class ReportExceptionTest {

    @Test
    fun shouldGoOnPostFound() {
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
        val report: ReportComment = ReportComment(123, 0, 1)

        //act
        service.add(postTest)
        service.createComment(comment)
        val makeReport = service.createReport(report)

        //assert
        assertEquals(makeReport, report)
    }

    @Test(expected = PostNotFoundException::class)
    fun shouldThrowPostNotFound() {
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
        val report: ReportComment = ReportComment(123, 5, 3)

        //act
        service.add(postTest)
        service.createComment(comment)
        service.createReport(report)
    }

    @Test
    fun existingEnum() {
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
        val report: ReportComment = ReportComment(123, 0, 6)

        //act
        service.add(postTest)
        service.createComment(comment)
        service.createReport(report)
    }

    @Test(expected = NoSuchReportException::class)
    fun nonExistingEnum() {
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
        val report: ReportComment = ReportComment(123, 0, 10)

        //act
        service.add(postTest)
        service.createComment(comment)
        service.createReport(report)
    }
}