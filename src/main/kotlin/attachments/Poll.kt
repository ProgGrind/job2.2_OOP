package attachments

class Poll (
    val id: Int,
    val ownerId: Int,
    val question: String,
    val created: Int,
    val votes: Int
)