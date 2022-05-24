import report.ReportComment

data class Note (
    val id: Int = 0,
    val title: String,
    val text: String,
    val existing: Boolean = true
)