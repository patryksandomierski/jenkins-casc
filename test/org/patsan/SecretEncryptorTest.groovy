package org.patsan

import org.junit.Test

import static org.assertj.core.api.Assertions.assertThat
import static org.assertj.core.api.Assertions.catchThrowable

class SecretEncryptorTest {

    static {
        System.setProperty("groovy.grape.enable", "false")
    }

    @Test
    void shouldEncrypt() {
        // given
        String password = 'sample-password'
        String value = 'sample-value'
        SecretEncryptor encryptor = new SecretEncryptor(password)

        // when
        String encryptedVal = encryptor.encrypt(value)

        // then
        assertThat(encryptedVal).isNotNull().isNotEqualTo(value)
    }

    @Test
    void shouldDecrypt() {
        // given
        String password = 'sample-password'
        String value = 'sample-value'
        SecretEncryptor encryptor = new SecretEncryptor(password)
        String encryptedVal = encryptor.encrypt(value)

        // when
        String decryptedVal = encryptor.decrypt(encryptedVal)

        // then
        assertThat(decryptedVal).isEqualTo(value)
    }

    @Test
    void shouldNotDecryptWhenPasswordDoesNotMatch() {
        // given
        String password = 'sample-password'
        String value = 'sample-value'
        SecretEncryptor encryptor = new SecretEncryptor(password)
        String encryptedVal = encryptor.encrypt(value)

        // when
        encryptor = new SecretEncryptor('invalid-password')
        Throwable thrown = catchThrowable({ ->
            encryptor.decrypt(encryptedVal)
        })

        assertThat(thrown).isInstanceOf(RuntimeException).hasMessage("value could not be decrypted")
    }
}
