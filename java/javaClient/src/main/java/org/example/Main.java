package org.example;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.indices.GetIndicesSettingsResponse;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.message.BasicHeader;
import org.elasticsearch.client.RestClient;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;


public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println("Hello world!");
        // URL and API key
        String serverUrl = "https://jihyun-elasticstack-8-1.es.us-central1.gcp.cloud.es.io";
        String apiKey = "LWFZb3o0b0JoMHBLMkVNdmp3T3Y6MDZ4RGFZMldRT2lTbW94MDJXSWxFQQ==";

// Create the low-level client
        RestClient restClient = RestClient
                .builder(HttpHost.create(serverUrl))
                .setDefaultHeaders(new Header[]{
                        new BasicHeader("Authorization",  "ApiKey " + apiKey)
                })
                .build();

// Create the transport with a Jackson mapper
        ElasticsearchTransport transport = new RestClientTransport(
                restClient, new JacksonJsonpMapper());

// And create the API client
        ElasticsearchClient esClient = new ElasticsearchClient(transport);

        GetIndicesSettingsResponse getIndicesSettingsResponse = esClient.indices().getSettings(gisr -> gisr.index("kibana_sample_data_ecommerce"));
        System.out.println(getIndicesSettingsResponse);

        System.out.println(getIndicesSettingsResponse.get("kibana_sample_data_ecommerce").settings().index().blocks().write());
//        System.out.println(getIndicesSettingsResponse.get("kibana_sample_data_ecommerce").settings().blocks().write());

//
//        System.out.println(getIndicesSettingsResponse.get("1tc9vunbbfkz").settings().blocks.write());





//        String settingsOutput = Objects.requireNonNull(getIndicesSettingsResponse.get("kibana_sample_data_ecommerce").settings()).toString();
//
//        String blocksKey = "\"blocks\":";
//        String writeKey = "\"write\":";
//
//        int blocksIndex = settingsOutput.indexOf(blocksKey);
//        int writeIndex = settingsOutput.indexOf(writeKey, blocksIndex);
//
//        if (blocksIndex != -1 && writeIndex != -1) {
//            String sub = settingsOutput.substring(writeIndex + writeKey.length()).trim();
//            String value = sub.startsWith("true") ? "true" : (sub.startsWith("false") ? "false" : "null");
//            System.out.println(value);
//        } else {
//            System.out.println("block > write key not found");
//        }
    }
}