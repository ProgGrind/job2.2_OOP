package attachments

data class PhotoAttachment (
    val photo: Photo,
    override val type: String = "Photo"
): Attachment