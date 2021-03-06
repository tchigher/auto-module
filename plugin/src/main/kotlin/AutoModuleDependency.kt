typealias AutoModuleDependency = Map<String, String>

@Suppress("unused") // Api
fun autoModuleDependency(
    path: String,
    configuration: String? = null
): AutoModuleDependency = mapOfNonNull(
    "path" to path,
    "configuration" toMaybe configuration
)

val AutoModuleDependency.path: String
    get() = this["path"] ?: error("Missing dependency path in $this")

@Suppress("unused") // Api
infix fun AutoModuleDependency.configuration(configuration: String): AutoModuleDependency =
    this + mapOf("configuration" to configuration)

private fun <K, V> mapOfNonNull(vararg entries: Pair<K, V>?): Map<K, V> =
    entries.filterNotNull().toMap()

internal infix fun <K, V> K.toMaybe(value: V?): Pair<K, V>? = value?.let { this to it }