package attachments

data class VideoAttachment (
    val video: Video,
    override val type: String = "Video"
): Attachment