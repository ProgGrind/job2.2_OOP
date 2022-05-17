package attachments

data class DocumentAttachment (
    val document: Document,
    override val type: String = "Document"
): Attachment