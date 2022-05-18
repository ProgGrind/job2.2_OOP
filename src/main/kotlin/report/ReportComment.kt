package report

class ReportComment (
    val ownerId: Int,
    val commentId: Int,
    val reasonId: Int
)

enum class Reason (reasonId: Int) {
    SPAM(0),
    CHILD(1),
    EXTREMISM(2),
    VIOLENCE(3),
    DRUG(4),
    ADULT(5),
    INSULT(6)
}