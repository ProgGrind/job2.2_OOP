class WallService {
    private var posts = emptyArray<Post>()

    fun add(post: Post): Post {
//        var idGenerate = post.id + 1
//        post.id = idGenerate

      val postNewId = post.copy(id = post.id + 1)

      posts += postNewId
      return posts.last()
    }

    fun update(post: Post): Boolean {
        var upd = false
        for ((index, element) in posts.withIndex()) {
            if (element.id == post.id) {
                posts[index] = element.copy(
                    id = post.id,
                    ownerId = post.ownerId,
                    fromId = post.fromId,
                    createdBy = post.createdBy,
                    date = post.date,
                    text = post.text,
                    replyOwnerId = post.replyOwnerId,
                    replyPostId = post.replyPostId,
                    friendsOnly = post.friendsOnly,
                    comments = post.comments,
                    copyright = post.copyright,
                    likes = post.likes,
                    reposts = post.reposts,
                    views = post.views,
                    postType = post.postType,
                    signerId = post.signerId,
                    canPin = post.canPin,
                    canDelete = post.canDelete,
                    canEdit = post.canEdit,
                    isPinned = post.isPinned,
                    markedAsAds = post.markedAsAds,
                    isFavorite = post.isFavorite,
                    postponedId = post.postponedId
                )
                upd = true
            }
        }
        return upd
    }
}

