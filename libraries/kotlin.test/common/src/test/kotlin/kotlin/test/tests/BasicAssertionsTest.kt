/*
 * Copyright 2010-2018 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package kotlin.test.tests

import kotlin.test.*

class BasicAssertionsTest {
    @Test
    fun testAssertEquals() {
        assertEquals(1, 1)
    }

    @Test
    fun testAssertSame() {
        val instance: Any = object {}
        assertSame(instance, instance)
    }

    @Test
    fun testAssertEqualsString() {
        assertEquals("a", "a")
    }

    @Test
    fun testAssertFailsWith() {
        assertFailsWith<IllegalStateException> { throw IllegalStateException() }
        assertFailsWith<AssertionError> { throw AssertionError() }
    }

    @Test
    fun testAssertFailsWithFails() {
        assertTrue(true) // at least one assertion required for qunit

        withDefaultAsserter run@{
            try {
                assertFailsWith<IllegalStateException> { throw IllegalArgumentException() }
            } catch (e: AssertionError) {
                return@run
            }
            throw AssertionError("Expected to fail")
        }

        withDefaultAsserter run@{
            try {
                assertFailsWith<IllegalStateException> { }
            } catch (e: AssertionError) {
                return@run
            }
            throw AssertionError("Expected to fail")
        }
    }

    @Test
    fun testAssertFailsWithClass() {
        assertFailsWith(IllegalArgumentException::class) {
            throw IllegalArgumentException("This is illegal")
        }
    }

    @Test
    fun testAssertFailsWithClassFails() {
        checkFailedAssertion {
            assertFailsWith(IllegalArgumentException::class) { throw IllegalStateException() }
        }

        checkFailedAssertion {
            assertFailsWith(Exception::class) { }
        }
    }

    @Test
    fun testAssertEqualsFails() {
        checkFailedAssertion { assertEquals(1, 2) }
    }

    @Test
    fun testAssertSameFails() {
        val instance1: Any = object {}
        val instance2: Any = object {}
        checkFailedAssertion { assertSame(instance1, instance2) }
    }

    @Test
    fun testAssertTrue() {
        assertTrue(true)
        assertTrue { true }
    }

    @Test()
    fun testAssertTrueFails() {
        checkFailedAssertion { assertTrue(false) }
        checkFailedAssertion { assertTrue { false } }
    }

    @Test
    fun testAssertFalse() {
        assertFalse(false)
        assertFalse { false }
    }

    @Test
    fun testAssertFalseFails() {
        checkFailedAssertion { assertFalse(true) }
        checkFailedAssertion { assertFalse { true } }
    }

    @Test
    fun testAssertFails() {
        assertFails { throw IllegalStateException() }
    }

    @Test()
    fun testAssertFailsFails() {
        checkFailedAssertion { assertFails { } }
    }


    @Test
    fun testAssertNotEquals() {
        assertNotEquals(1, 2)
    }

    @Test
    fun testAssertNotSame() {
        val instance1: Any = object {}
        val instance2: Any = object {}
        assertNotSame(instance1, instance2)
    }

    @Test()
    fun testAssertNotEqualsFails() {
        checkFailedAssertion { assertNotEquals(1, 1) }
    }

    @Test
    fun testAssertNotSameFails() {
        val instance: Any = object {}
        checkFailedAssertion { assertNotSame(instance, instance) }
    }

    @Test
    fun testAssertNotNull() {
        assertNotNull(true)
    }

    @Test()
    fun testAssertNotNullFails() {
        checkFailedAssertion { assertNotNull(null) }
    }

    @Test
    fun testAssertNotNullLambda() {
        assertNotNull("") { assertEquals("", it) }
    }

    @Test
    fun testAssertNotNullLambdaFails() {
        checkFailedAssertion {
            val value: String? = null
            assertNotNull(value) {
                it.substring(0, 0)
            }
        }
    }

    @Test
    fun testAssertNull() {
        assertNull(null)
    }

    @Test
    fun testAssertNullFails() {
        checkFailedAssertion { assertNull("") }
    }

    @Test()
    fun testFail() {
        checkFailedAssertion { fail("should fail") }
    }

    @Test
    fun testExpect() {
        expect(1) { 1 }
    }

    @Test
    fun testExpectFails() {
        checkFailedAssertion { expect(1) { 2 } }
    }

    @Test
    fun assertContentEqualsArray() {
        assertContentEquals(arrayOf(intArrayOf(1), longArrayOf(2L, 3L)), arrayOf(intArrayOf(1), longArrayOf(2L, 3L)))
        checkFailedAssertion {
            assertContentEquals(arrayOf(intArrayOf(1), longArrayOf(2L, 3L)), arrayOf(intArrayOf(3), longArrayOf(2L, 1L)))
        }

        assertContentNotEquals(arrayOf(intArrayOf(1), longArrayOf(2L, 3L)), arrayOf(intArrayOf(3), longArrayOf(2L, 1L)))
        checkFailedAssertion {
            assertContentNotEquals(arrayOf(intArrayOf(1), longArrayOf(2L, 3L)), arrayOf(intArrayOf(1), longArrayOf(2L, 3L)))
        }
    }

    @Test
    fun assertContentEqualsBooleans() {
        assertContentEquals(booleanArrayOf(true, false, true), booleanArrayOf(true, false, true))
        checkFailedAssertion {
            assertContentEquals(booleanArrayOf(true, false, true), booleanArrayOf(false, true, false))
        }

        assertContentNotEquals(booleanArrayOf(true, false, true), booleanArrayOf(false, true, false))
        checkFailedAssertion {
            assertContentNotEquals(booleanArrayOf(true, false, true), booleanArrayOf(true, false, true))
        }
    }

    @Test
    fun assertContentEqualsBytes() {
        assertContentEquals(byteArrayOf(1.toByte(), 2.toByte(), 3.toByte()), byteArrayOf(1.toByte(), 2.toByte(), 3.toByte()))
        checkFailedAssertion {
            assertContentEquals(byteArrayOf(1.toByte(), 2.toByte(), 3.toByte()), byteArrayOf(3.toByte(), 2.toByte(), 1.toByte()))
        }

        assertContentNotEquals(byteArrayOf(1.toByte(), 2.toByte(), 3.toByte()), byteArrayOf(3.toByte(), 2.toByte(), 1.toByte()))
        checkFailedAssertion {
            assertContentNotEquals(byteArrayOf(1.toByte(), 2.toByte(), 3.toByte()), byteArrayOf(1.toByte(), 2.toByte(), 3.toByte()))
        }
    }

    @Test
    fun assertContentEqualsChars() {
        assertContentEquals(charArrayOf('a' ,'b', 'c'), charArrayOf('a', 'b', 'c'))
        checkFailedAssertion {
            assertContentEquals(charArrayOf('a' ,'b', 'c'), charArrayOf('c', 'b', 'a'))
        }

        assertContentNotEquals(charArrayOf('a' ,'b', 'c'), charArrayOf('c', 'b', 'a'))
        checkFailedAssertion {
            assertContentNotEquals(charArrayOf('a' ,'b', 'c'), charArrayOf('a', 'b', 'c'))
        }
    }

    @Test
    fun assertContentEqualsDoubles() {
        assertContentEquals(doubleArrayOf(1.0, 2.0, 3.0), doubleArrayOf(1.0, 2.0, 3.0))
        checkFailedAssertion {
            assertContentEquals(doubleArrayOf(1.0, 2.0, 3.0), doubleArrayOf(3.0, 2.0, 1.0))
        }

        assertContentNotEquals(doubleArrayOf(1.0, 2.0, 3.0), doubleArrayOf(3.0, 2.0, 1.0))
        checkFailedAssertion {
            assertContentNotEquals(doubleArrayOf(1.0, 2.0, 3.0), doubleArrayOf(1.0, 2.0, 3.0))
        }
    }

    @Test
    fun assertContentEqualsFloats() {
        assertContentEquals(floatArrayOf(1f, 2f, 3f), floatArrayOf(1f, 2f, 3f))
        checkFailedAssertion {
            assertContentEquals(floatArrayOf(1f, 2f, 3f), floatArrayOf(3f, 2f, 1f))
        }

        assertContentNotEquals(floatArrayOf(1f, 2f, 3f), floatArrayOf(3f, 2f, 1f))
        checkFailedAssertion {
            assertContentNotEquals(floatArrayOf(1f, 2f, 3f), floatArrayOf(1f, 2f, 3f))
        }
    }

    @Test
    fun assertContentEqualsInts() {
        assertContentEquals(intArrayOf(1, 2, 3), intArrayOf(1, 2, 3))
        checkFailedAssertion {
            assertContentEquals(intArrayOf(1, 2, 3), intArrayOf(3, 2, 1))
        }

        assertContentNotEquals(intArrayOf(1, 2, 3), intArrayOf(3, 2, 1))
        checkFailedAssertion {
            assertContentNotEquals(intArrayOf(1, 2, 3), intArrayOf(1, 2, 3))
        }
    }

    @Test
    fun assertContentEqualsLongs() {
        assertContentEquals(longArrayOf(1L, 2L, 3L), longArrayOf(1L, 2L, 3L))
        checkFailedAssertion {
            assertContentEquals(longArrayOf(1L, 2L, 3L), longArrayOf(3L, 2L, 1L))
        }

        assertContentNotEquals(longArrayOf(1L, 2L, 3L), longArrayOf(3L, 2L, 1L))
        checkFailedAssertion {
            assertContentNotEquals(longArrayOf(1L, 2L, 3L), longArrayOf(1L, 2L, 3L))
        }
    }

    @Test
    fun assertContentEqualsShorts() {
        assertContentEquals(shortArrayOf(1.toShort(), 2.toShort(), 3.toShort()), shortArrayOf(1.toShort(), 2.toShort(), 3.toShort()))
        checkFailedAssertion {
            assertContentEquals(shortArrayOf(1.toShort(), 2.toShort(), 3.toShort()), shortArrayOf(3.toShort(), 2.toShort(), 1.toShort()))
        }

        assertContentNotEquals(shortArrayOf(1.toShort(), 2.toShort(), 3.toShort()), shortArrayOf(3.toShort(), 2.toShort(), 1.toShort()))
        checkFailedAssertion {
            assertContentNotEquals(shortArrayOf(1.toShort(), 2.toShort(), 3.toShort()), shortArrayOf(1.toShort(), 2.toShort(), 3.toShort()))
        }
    }

    @Test
    @ExperimentalUnsignedTypes
    fun assertContentEqualsUBytes() {
        assertContentEquals(ubyteArrayOf(1.toUByte(), 2.toUByte(), 3.toUByte()), ubyteArrayOf(1.toUByte(), 2.toUByte(), 3.toUByte()))
        checkFailedAssertion {
            assertContentEquals(ubyteArrayOf(1.toUByte(), 2.toUByte(), 3.toUByte()), ubyteArrayOf(3.toUByte(), 2.toUByte(), 1.toUByte()))
        }

        assertContentNotEquals(ubyteArrayOf(1.toUByte(), 2.toUByte(), 3.toUByte()), ubyteArrayOf(3.toUByte(), 2.toUByte(), 1.toUByte()))
        checkFailedAssertion {
            assertContentNotEquals(ubyteArrayOf(1.toUByte(), 2.toUByte(), 3.toUByte()), ubyteArrayOf(1.toUByte(), 2.toUByte(), 3.toUByte()))
        }
    }

    @Test
    @ExperimentalUnsignedTypes
    fun assertContentEqualsUShorts() {
        assertContentEquals(
            ushortArrayOf(1.toUShort(), 2.toUShort(), 3.toUShort()),
            ushortArrayOf(1.toUShort(), 2.toUShort(), 3.toUShort())
        )
        checkFailedAssertion {
            assertContentEquals(
                ushortArrayOf(1.toUShort(), 2.toUShort(), 3.toUShort()),
                ushortArrayOf(3.toUShort(), 2.toUShort(), 1.toUShort())
            )
        }

        assertContentNotEquals(
            ushortArrayOf(1.toUShort(), 2.toUShort(), 3.toUShort()),
            ushortArrayOf(3.toUShort(), 2.toUShort(), 1.toUShort())
        )
        checkFailedAssertion {
            assertContentNotEquals(
                ushortArrayOf(1.toUShort(), 2.toUShort(), 3.toUShort()),
                ushortArrayOf(1.toUShort(), 2.toUShort(), 3.toUShort())
            )
        }
    }

    @Test
    @ExperimentalUnsignedTypes
    fun assertContentEqualsUInts() {
        assertContentEquals(uintArrayOf(1u, 2u, 3u), uintArrayOf(1u, 2u, 3u))
        checkFailedAssertion {
            assertContentEquals(uintArrayOf(1u, 2u, 3u), uintArrayOf(3u, 2u, 1u))
        }

        assertContentNotEquals(uintArrayOf(1u, 2u, 3u), uintArrayOf(3u, 2u, 1u))
        checkFailedAssertion {
            assertContentNotEquals(uintArrayOf(1u, 2u, 3u), uintArrayOf(1u, 2u, 3u))
        }
    }

    @Test
    @ExperimentalUnsignedTypes
    fun assertContentEqualsULongs() {
        assertContentEquals(ulongArrayOf(1uL, 2uL, 3uL), ulongArrayOf(1uL, 2uL, 3uL))
        checkFailedAssertion {
            assertContentEquals(ulongArrayOf(1uL, 2uL, 3uL), ulongArrayOf(3uL, 2uL, 1uL))
        }

        assertContentNotEquals(ulongArrayOf(1uL, 2uL, 3uL), ulongArrayOf(3uL, 2uL, 1uL))
        checkFailedAssertion {
            assertContentNotEquals(ulongArrayOf(1uL, 2uL, 3uL), ulongArrayOf(1uL, 2uL, 3uL))
        }
    }
}


private fun checkFailedAssertion(assertion: () -> Unit) {
    assertFailsWith<AssertionError> { withDefaultAsserter(assertion) }
}

private fun withDefaultAsserter(block: () -> Unit) {
    val current = overrideAsserter(DefaultAsserter)
    try {
        block()
    } finally {
        overrideAsserter(current)
    }
}
