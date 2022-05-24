data class Comment (
    val	id: Int = 0,
    val postId: Int,
    val fromId: Int,
    val date: Int,
    val text: String,
    var existing: Boolean = true
)