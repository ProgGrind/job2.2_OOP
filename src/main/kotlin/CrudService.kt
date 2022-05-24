interface CrudService<E> {

    val entities: MutableList<E>

    fun add(entity: E): Int

    fun delete(id: Int)

    fun edit(entity: E): Boolean

    fun read(): List<E> {
        return entities
    }

    fun getById(id: Int): E

    fun restore(id: Int): E
}