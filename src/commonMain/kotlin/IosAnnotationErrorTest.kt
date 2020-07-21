@Retention(AnnotationRetention.SOURCE)
@Target(AnnotationTarget.TYPE)
annotation class TestAnnotation

@Retention(AnnotationRetention.SOURCE)
@Target(AnnotationTarget.TYPE)
annotation class TestAnnotationWithGeneric<T>

// this class compiles without issue:
class IosAnnotationNoIssueTest(var arg1: @TestAnnotation String)

// this class fails with:
// e: kotlin.KotlinNullPointerException
//        at org.jetbrains.kotlin.backend.common.serialization.IrFileSerializer.serializeTypeArguments(IrFileSerializer.kt:293)
//        at org.jetbrains.kotlin.backend.common.serialization.IrFileSerializer.serializeMemberAccessCommon(IrFileSerializer.kt:495)
//        at org.jetbrains.kotlin.backend.common.serialization.IrFileSerializer.serializeConstructorCall(IrFileSerializer.kt:532)
//        at org.jetbrains.kotlin.backend.common.serialization.IrFileSerializer.serializeAnnotations(IrFileSerializer.kt:305)
//        at org.jetbrains.kotlin.backend.common.serialization.IrFileSerializer.serializeSimpleType(IrFileSerializer.kt:329)
//        at org.jetbrains.kotlin.backend.common.serialization.IrFileSerializer.serializeIrTypeData(IrFileSerializer.kt:365)
//        at org.jetbrains.kotlin.backend.common.serialization.IrFileSerializer.serializeIrType(IrFileSerializer.kt:427)
//        ...
class IosAnnotationErrorTest(var arg1: @TestAnnotationWithGeneric<Any> String)