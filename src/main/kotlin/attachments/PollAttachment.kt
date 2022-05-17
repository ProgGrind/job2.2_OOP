package attachments

data class PollAttachment (
    val poll: Poll,
    override val type: String = "Poll"
): Attachment