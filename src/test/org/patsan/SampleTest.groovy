package org.patsan

import org.junit.Test

import static org.assertj.core.api.Assertions.assertThat

class SampleTest {
    @Test
    void sayHelloTest() {
        Sample sample = new Sample()
        assertThat(sample.sayHello()).isEqualTo('hello')
    }
}
