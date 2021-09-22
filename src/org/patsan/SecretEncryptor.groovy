package org.patsan

@Grab(group='org.jasypt', module='jasypt', version='1.9.3')
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor
import org.jasypt.encryption.pbe.config.EnvironmentStringPBEConfig
import org.jasypt.exceptions.EncryptionOperationNotPossibleException

class SecretEncryptor {

    private StandardPBEStringEncryptor encryptor

    SecretEncryptor(String password) {
        EnvironmentStringPBEConfig config = new EnvironmentStringPBEConfig()
        config.setPassword(password)
        encryptor = new StandardPBEStringEncryptor()
        encryptor.setConfig(config)
    }

    String encrypt(String value) {
        return encryptor.encrypt(value)
    }

    String decrypt(String value) {
        try {
            return encryptor.decrypt(value)
        } catch(EncryptionOperationNotPossibleException ignored) {
            throw new RuntimeException('value could not be decrypted')
        }
    }
}
