package Stripe;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;

public class AcceptLanguageHeader {
    public static void main(String[] args) {
        AcceptLanguageHeader alh = new AcceptLanguageHeader();


        HashSet<String> servers = new HashSet<>();
        servers.add("fr-FR");
        servers.add("fr-CA");
        servers.add("fr-BG");
        servers.add("en-US");

        String str = alh.parseAcceptLanguage3("fr-FR;q=1, fr-CA;q=0, en-US;q=0.5", servers);
        System.out.println(str);
    }


    /*
    part1
    parse_accept_language(
  "en-US, fr-CA, fr-FR",  # the client's Accept-Language header, a string
  ["fr-FR", "en-US"]      # the server's supported languages, a set of strings
)

part2
parse_accept_language("fr", ["en-US", "fr-CA", "fr-FR"])
returns: ["fr-CA", "fr-FR"]


part3
    parse_accept_language("fr-FR;q=1, fr-CA;q=0, *;q=0.5", ["fr-FR", "fr-CA", "fr-BG", "en-US"])
    returns: ["fr-FR", "fr-BG", "en-US", "fr-CA"]

     */
    public String parseAcceptLanguage1(String clientHeader, HashSet<String> serverHeaders){
        String[] clientHeaders = clientHeader.split("\\s*,\\s*");
        StringBuffer sb = new StringBuffer();
        boolean isFirst = true;
        for(String h : clientHeaders){
            if(serverHeaders.contains(h)){
                if(!isFirst){
                    sb.append(", ");
                }
                sb.append(h);
                isFirst=false;
            }

        }
        return sb.toString();
    }

    public String parseAcceptLanguage2(String clientHeader, HashSet<String> serverHeaders){
        String[] clientHeaders = clientHeader.split("\\s*,\\s*");

        Map<String, HashSet<String>> serverTagMap =  new HashMap<>();
        for(String h : serverHeaders){
            String lang = h.split("-")[0];
            serverTagMap.putIfAbsent(lang,new HashSet<>());
            serverTagMap.get(lang).add(h);
        }


        StringBuffer sb = new StringBuffer();
        boolean isFirst = true;
        for(String h : clientHeaders){
            if(serverHeaders.contains(h)){
                if(!isFirst){
                    sb.append(", ");
                }
                sb.append(h);
                isFirst=false;
            } else if(serverTagMap.containsKey(h)){
                HashSet<String> set = serverTagMap.get(h);
                for(String lang: set){
                    if(!isFirst){
                        sb.append(", ");
                    }
                    sb.append(lang);
                    isFirst=false;
                }
            }

        }
        return sb.toString();
    }


    public String parseAcceptLanguage3(String clientHeader,  HashSet<String>  serverHeader){
        String[] clientHeaders = clientHeader.split("\\s*,\\s*");

        Map<String, HashSet<String>> serverTagMap =  new HashMap<>();
        for(String h : serverHeader){
            String lang = h.split("-")[0];
            serverTagMap.putIfAbsent(lang,new HashSet<>());
            serverTagMap.get(lang).add(h);
        }

        PriorityQueue<String[]> maxHeap = new PriorityQueue<>((a, b) ->
                a[1].equals(b[1]) ? 0 : (
                        Double.valueOf(b[1]) - Double.valueOf(a[1]) > 0 ? 1 : -1)
        );
        Map<String, String> weightMap= new HashMap<>();

        for(String clHeader : clientHeaders){
            String[] str = clHeader.split(";");
            String clLang = str[0];
            String weight = str[1].substring(2,str.length);

            if(serverHeader.contains(clLang)){
                maxHeap.add(new String[]{clLang, weight});
            }
        }

        StringBuffer sb = new StringBuffer();
        boolean isFirst = true;

        while (!maxHeap.isEmpty()){
            if(!isFirst){
                sb.append(", ");
            }
            sb.append(maxHeap.poll()[0]);
            isFirst=false;
        }


        return sb.toString();
    }

}
