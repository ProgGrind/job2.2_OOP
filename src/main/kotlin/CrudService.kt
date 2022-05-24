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

//val entities: MutableList<E>
//
//fun add(entity: E): Int {
////        nextId++
//    val newEntity = entity.copy(id = entity.id + 1)
//    entities.add(newEntity)
//    return newEntity.id
//}
//
//fun delete(entId: Int) {
//    for (entity in entities) {
//        if (entity.id == entId) {
//            val deleting = mutableListOf<E>()
//            deleting.add(entity.copy(id = entity.id, existing = false))
//            entities.remove(entity)
//        }
//    }
//}
//
//fun edit(entity: E): Boolean {
//    var ed = false
//    for ((index, element) in entities.withIndex()) {
//        if (element.id == entity.id) {
//            entities[index] = element.copy(id = entity.id)
//            ed = true
//        }
//    }
//    return ed
//}
//
//fun read(): List<E> {
//    return entities
//}
//
//fun getById(entId: Int): E {
//    for (entity in entities) {
//        if (entity.id == entId)
//            return entity
//    }
//    throw PostNotFoundException("Not found!")
//}
//
//fun restore(entId: Int): E {
//    for (entity in entities) {
//        if (entity.id == entId) {
//            return entity.copy(id = entity.id, existing = true)
//        }
//    }
//    throw PostNotFoundException("Wasn't deleted!")
//}
//}