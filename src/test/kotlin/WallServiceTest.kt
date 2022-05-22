import attachments.*
import org.junit.Test

import org.junit.Assert.*

class WallServiceTest {



    @Test
    fun testAdd() {
        //arrange
        val wallService = WallService()
        val postTest: Post = Post(
            0, 123, 321, 456, 10012022, "my test text post", 654, 789,
            987, Comment(2, 0,1, 12102022, "My Comment", true), "no copyright here",
            Likes(1, false, false, false), Reposts(1, true), Views(1),
            "Great Post", AudioAttachment(Audio(1,123, "Hey", "Ba-da-boom", 163, 11122022)),100, false, false, false, false, false,
            false, 123
        )

        //act
        val resultTest = wallService.add(post = postTest)

        //assert
        assertNotEquals(0, resultTest.id)
    }


    @Test
    fun updateExisting() {
        //arrange
        // создаём целевой сервис
        val service = WallService()
        // заполняем постами
        val test1 = service.add(
            Post(
                1, 222, 333, 555, 10012022, "my new test text post", 666, 789,
                987, Comment(2, 0,1, 12102022, "My Comment", true), "no copyright here",
                Likes(1, false, false, false), Reposts(1, true), Views(1),
                "Great Post", AudioAttachment(Audio(1,123, "Hey", "Ba-da-boom", 163, 11122022)),100, false, false, false, false, false,
                false, 123
            )
        )

        val idTest = test1.id

        // создаём информацию об обновлении
        val update = Post(idTest, 123, 321, 456, 1012022, "my updated test text post", 654, 789,
            987, Comment(2, 0,1, 12102022, "My Comment", true), "no copyright here",
            Likes(1, false, false, false), Reposts(1, true), Views(1),
            "Great Post", AudioAttachment(Audio(1,123, "Hey", "Ba-da-boom", 163, 11122022)),100, false, false, false, false, false,
            false, 123
        )

        // выполняем целевое действие
        val result = service.update(update)

        // проверяем результат (используйте assertTrue или assertFalse)
        assertTrue(result)

    }


    @Test
    fun updateNonExisting() {
        //arrange
        // создаём целевой сервис
        val service = WallService()
        // заполняем постами
        val test2 = service.add(
            Post(
                0, 222, 333, 555, 10012022, "my new test text post", 666, 789,
                987, Comment(2, 0,1, 12102022, "My Comment", true), "no copyright here",
                Likes(1, false, false, false), Reposts(1, true), Views(1),
                "Great Post", AudioAttachment(Audio(1,123, "Hey", "Ba-da-boom", 163, 11122022)),100, false, false, false, false, false,
                false, 123
            )
        )
        service.add(
            Post(
                0, 444, 555, 777, 10022022, "my newest test text post", 654, 789,
                987, Comment(2, 0,1, 12102022, "My Comment", true), "no copyright here",
                Likes(1, false, false, false), Reposts(1, true), Views(1),
                "Great Post", AudioAttachment(Audio(1,123, "Hey", "Ba-da-boom", 163, 11122022)),100, false, false, false, false, false,
                false, 123
            )
        )
        service.add(
            Post(
                0, 777, 444, 456, 10032022, "my new newest test text post", 888, 789,
                987, Comment(2, 0,1, 12102022, "My Comment", true), "no copyright here",
                Likes(1, false, false, false), Reposts(1, true), Views(1),
                "Great Post", AudioAttachment(Audio(1,123, "Hey", "Ba-da-boom", 163, 11122022)),100, false, false, false, false, false,
                false, 123
            )
        )
         //создаём информацию об обновлении
        val update = Post(
            20000, 123, 321, 456, 1012022, "my updated test text post", 654, 789,
            987, Comment(2, 0,1, 12102022, "My Comment", true), "no copyright here",
            Likes(1, false, false, false), Reposts(1, true), Views(1),
            "Great Post", AudioAttachment(Audio(1,123, "Hey", "Ba-da-boom", 163, 11122022)),100, false, false, false, false, false,
            false, 123
        )

        // выполняем целевое действие
        val result = service.update(update)

        // проверяем результат (используйте assertTrue или assertFalse)
        assertFalse(result)

    }
}

