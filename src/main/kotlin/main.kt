import attachments.*



fun main(){
     val post = Post(
         id = 0,
         ownerId = 123,
         fromId = 321,
         createdBy = 456,
         date = 1012022,
         text = "my post",
         replyOwnerId = 654,
         replyPostId = 789,
         friendsOnly = 987,
         comment = Comment(2, 0,1, 12102022, "My Comment", true),
         copyright = "no copyright here",
         likes = Likes(1, false, false, false),
         reposts = Reposts(1, true),
         views = Views(1),
         postType = "Great Post",
         attachments = AudioAttachment(Audio(1,123, "Hey", "Ba-da-boom", 163, 11122022)),
         signerId = 100,
         canPin = false,
         canDelete = false,
         canEdit = false,
         isPinned = false,
         markedAsAds = false,
         isFavorite = false,
         postponedId = 123
     )


     val wallService = WallService()
     println(wallService.createComment(Comment(1, 1, 2, 31012022,"Comment", true)))



     println(wallService.add(post).id)


 }


