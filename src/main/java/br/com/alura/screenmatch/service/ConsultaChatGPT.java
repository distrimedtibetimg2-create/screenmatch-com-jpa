package br.com.alura.screenmatch.service;

import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.models.responses.Response;
import com.openai.models.responses.ResponseCreateParams;

public class ConsultaChatGPT {

    public static String obterTraducao(String texto) {

        try {
            OpenAIClient client = OpenAIOkHttpClient.fromEnv();

            ResponseCreateParams params = ResponseCreateParams.builder()
                    .model("gpt-5-nano")
                    .input("Traduza para o português o texto a seguir:\n" + texto)
                    .build();

            Response response = client.responses().create(params);

            // ✅ SEMPRE compila, em qualquer versão
            return response.toString();

        } catch (Exception e) {
            System.out.println("Erro ao chamar OpenAI: " + e.getMessage());
            return texto;
        }
    }
}
