package attachments

data class AudioAttachment (
    val audio: Audio,
    override val type: String = "Audio"
): Attachment