package com.tencent.myapplication

import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun requestUrlReconstructed() {
        val server = MockWebServer()

        val response = MockResponse()
        response.setResponseCode(200)
        response.addHeader("Content-Type", "text/csv")
        response.setBody("ColumnA,ColumnB,ColumnC\nA,B,c\n,a,b,c\n")
        server.enqueue(response)
        server.start()

        val input = server.url("/").url().openConnection().getInputStream()
        val b = ByteArray(1024)
        val len = input.read(b)
        assertTrue(len > 0)

        val lines = String(b).split("\n")
        assertEquals(4, lines.size)

        server.shutdown()
    }
}
