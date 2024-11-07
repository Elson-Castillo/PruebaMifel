package com.prueba.mifel.servicio;

import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/*Autor: ING. Elson Castillo. Clase service que cifra una cadena de cualquier longitud con
AES/CBC/PKCS5Padding, haciendo uso de una llave pública y un vector de inicialización
*/

@Service
public class EncryptionService {

    private static final String ALGORITHM = "AES/CBC/PKCS5Padding";
    private final SecretKey secretKey;
    private final IvParameterSpec ivParameterSpec;

    public EncryptionService() throws NoSuchAlgorithmException {
        // Genera una llave AES de 256 bits
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(256);
        this.secretKey = keyGenerator.generateKey();

        // Genera un IV (vector de inicialización) de 16 bytes para AES
        byte[] iv = new byte[16];
        System.arraycopy("1234567890123456".getBytes(), 0, iv, 0, iv.length); // Para pruebas, usa un IV fijo
        this.ivParameterSpec = new IvParameterSpec(iv);
    }

    public String encrypt(String data) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivParameterSpec);
        byte[] encryptedData = cipher.doFinal(data.getBytes());

        // Codifica en Base64 para transmitir el texto cifrado en un formato legible
        return Base64.getEncoder().encodeToString(encryptedData);
    }

    // Método para convertir la llave a Base64 para mostrarla si es necesario
    public String getEncodedSecretKey() {
        return Base64.getEncoder().encodeToString(secretKey.getEncoded());
    }
}
