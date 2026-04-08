package ru.itis.inf501.lab2_9_yandex;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class HttpClientExample {
    public static void main(String[] args) {
        try {
            // Создаем клиент
            HttpClient client = HttpClient.newHttpClient();

            // String url = "https://yandex.ru/maps/api/masstransit/getVehiclesInfoWithRegion?ajax=1&csrfToken=4fd11ee112192bfdf089f9dbc4be284d60851b67%3A1774418302&lang=ru&lineId=2079775734&ll=49.132378%2C55.803212&locale=ru_RU&s=716464481&sessionId=1774418301922270-10466358929881314970-balancer-l7leveler-kubr-yp-vla-107-BAL&spn=0.108662%2C0.094172&type=bus";

            // String url = "https://yandex.com/maps/api/masstransit/getVehiclesInfoWithRegion?ajax=1&csrfToken=b72f555c32b7b029900054bcef34249e72770e2f%3A1774430664&lang=ru&lineId=2079775734&ll=49.141261%2C55.810027&locale=ru_DE&s=2263401226&sessionId=1774430664491238-10440396876083746001-balancer-l7leveler-kubr-yp-vla-153-BAL&spn=0.128746%2C0.027599&type=bus";

            //String url = "https://yandex.com/maps/api/masstransit/getVehiclesInfoWithRegion?ajax=1&csrfToken=8e8da379db24eb125bc56fca128d261c7acd8db3%3A1774432360&lang=ru&lineId=2079775734&ll=49.103112%2C55.846879&locale=ru_DE&s=1460036573&sessionId=1774432360351267-10008567214648659754-balancer-l7leveler-kubr-yp-vla-153-BAL&spn=0.514984%2C0.072239&type=bus";
            //String url = "https://yandex.ru/maps/api/masstransit/getVehiclesInfoWithRegion?ajax=1&csrfToken=355a184e41c189e73eefeedb00d4c98b47b95679%3A1774533493&lang=ru&ll=49.095999%2C55.826708&locale=ru_RU&s=1774356871&sessionId=1774533493648484-3965006156104944712-balancer-l7leveler-kubr-yp-sas-214-BAL&spn=0.115844%2C0.250000";
            String url = "https://yandex.ru/maps/api/masstransit/getVehiclesInfoWithRegion?ajax=1&csrfToken=1e35d36b5b30500ef6e83ec0ad9b1427db6aa0ae%3A1774770429&lang=ru&ll=49.141261%2C55.810027&locale=ru_RU&s=281000005&sessionId=1774770429777720-11067840316453735157-balancer-l7leveler-kubr-yp-klg-9-BAL&spn=0.012960%2C0.040214";


            // Создаем запрос
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .header("Accept", "text/plain")
                    //.header("cookie","yandex_gid=240; my=YycCAAErAYDwAA==; yashr=327163131752827830; _ym_uid=1752845980715777770; gdpr=0; amcuid=4965084751752849916; yandexuid=6087275171752827830; yuidss=6087275171752827830; ymex=2068217553.yrts.1752857553#2068217552.yrtsi.1752857552; is_gdpr=0; is_gdpr_b=CJD7OhDgzAIoAg==; user-anniversary-story=1; skid=9588110971752997204; L=Rht9Z0BfYFZQQlpxA1NcZE19fENyd3JnFyEEFHAJGAkPDAEHHSI=.1758362641.1204009.349868.1b85f50aece1bb74921719bb93ddd8f9; yandex_login=osad4ayayelena; maps_routes_travel_mode=taxi; _ym_d=1768633598; pi=IreYzr43EfG0juYgSQhfazfgllVLGu+KIEPklNyVkXcsKS8FTD3zNpHvo7vd+EKW1lMXnVwhdG9JW94LcvcqBat/5rI=; alice_uuid=00000000000006087275171752827830; Session_id=3:1774362859.5.0.1752846693118:4VxQXQ:6ee7.1.2:1|1065437057.-1.2.3:1752846693|1130000069850438.-1.0.2:5512777.3:1758359470|3:11796523.939548.J-x8EiJXiIig_fZIlA6gZFMjWZw; sessar=1.1719225.CiB-1n9EWjEH7YNjlzEFI9UIY9kghUDdA-LL1QQZauzckQ.TC1vzUDOV8tAB03K44edZb3I4U09WvIAvghFGpHgBSc; sessionid2=3:1774362859.5.0.1752846693118:4VxQXQ:6ee7.1.2:1|1065437057.-1.2.3:1752846693|1130000069850438.-1.0.2:5512777.3:1758359470|3:11796523.939548.fakesign0000000000000000000; i=vhFXyy8bDKjr1ayGpmbOn7gnYPP9xMQ27pwalJakDrkvUxI6Sbb1WWHXagHm4l/hIorv+YQt50iP2VwzuV4bkalKRsQ=; cycada=3PDgxRYDrpCvLiHYJGar2MD44u0Lm/g+pSN2ZzpPhK0=; yclid_src=letu.ru:12209787921607426047:6087275171752827830; _ym_isad=1; isa=mWc9211eVEDkxcgRz4yNmOwHzgrUVgtR14yqrdM+Hl94CmHL79rpFqmPg4wXGH0n/tSm6BfAm4aNto21QUoBLiUCgSY=; sae=0:BCC3F30B-19DC-491A-AB11-5A0126A7DFC6:p:26.3.1.981:w:d:RU:20250718; alice_reqids=1774533323399036-7971548315767080288-b6xxvxwnwibtwwlz-BAL.1774533323~1774532945317992-1839314034824454992-hb6k2w7gp22jghp5-BAL.1774532945; maps_session_id=1774533493648484-3965006156104944712-balancer-l7leveler-kubr-yp-sas-214-BAL; yandex_expboxes=1512060%2C0%2C42%3B1508403%2C0%2C45%3B1497450%2C0%2C92%3B1494508%2C0%2C39%3B1515148%2C0%2C77%3B1502455%2C0%2C74%3B1509088%2C0%2C23%3B663874%2C0%2C3%3B663860%2C0%2C5%3B1257223%2C0%2C55%3B1493182%2C0%2C75%3B1513991%2C0%2C82; gpb=gpauto.55_742288%3A49_181997%3A118%3A0%3A1774533489; ys=def_bro.0#ead.2FECB7CF#newsca.native_cache#wprid.1774533328881403-2078526105168727927-balancer-l7leveler-kubr-yp-sas-214-BAL#ybzcc.ru; _yasc=UwdZ8lY4R7ZhaQ2iv8lYvMEx99bxXnPYRTbtVBsgST+H8vbaMZOTaXfkFyPSEXjnUFVdT5kLxO4gU18SFj9kSofcmeIWjuHaz4qUsa6CXji73SILET1lWFLFgkvBe50dcCeNC8GIJBlufG9FRPuJSnGX6FFCxNyD; yp=1800104567.bk-map.1#1784393554.cld.2378379-1#1790872906.dafs.31-3#1784457993.dc_neuro.10#1775233628.dlp.1#1774619478.duc.ru#1774540878.gpauto.55_742288:49_181997:118:0:1774533678#1776846545.hdrc.1#2073719470.multib.1#2089893364.pcs.0#2068211437.skin.d#1802969945.swntab.104894032#1785797766.szm.1_25:1536x960:1521x832:15#1774619478.uc.ru#2073722641.udn.cDrQkNC70ZHQvdCw; gpauto=55_742288:49_181997:118:0:1774533678; bh=Ek8iTm90KEE6QnJhbmQiO3Y9IjgiLCAiQ2hyb21pdW0iO3Y9IjE0NCIsICJZYUJyb3dzZXIiO3Y9IjI2LjMiLCAiWW93c2VyIjt2PSIyLjUiGgUieDg2IiIMIjI2LjMuMS45ODEiKgI/MDICIiI6CSJXaW5kb3dzIkIIIjE1LjAuMCJKBCI2NCJSZiJOb3QoQTpCcmFuZCI7dj0iOC4wLjAuMCIsICJDaHJvbWl1bSI7dj0iMTQ0LjAuNzU1OS45ODEiLCAiWWFCcm93c2VyIjt2PSIyNi4zLjEuOTgxIiwgIllvd3NlciI7dj0iMi41IloCPzBgj/iUzgZqIdzK4f8IktihsQOfz+HqA/v68OcN6//99g+e982UB/OBAg==")
                    .header("cookie","yandex_gid=240; my=YycCAAErAYDwAA==; yashr=327163131752827830; _ym_uid=1752845980715777770; gdpr=0; amcuid=4965084751752849916; yandexuid=6087275171752827830; yuidss=6087275171752827830; ymex=2068217553.yrts.1752857553#2068217552.yrtsi.1752857552; is_gdpr=0; is_gdpr_b=CJD7OhDgzAIoAg==; user-anniversary-story=1; skid=9588110971752997204; L=Rht9Z0BfYFZQQlpxA1NcZE19fENyd3JnFyEEFHAJGAkPDAEHHSI=.1758362641.1204009.349868.1b85f50aece1bb74921719bb93ddd8f9; yandex_login=osad4ayayelena; maps_routes_travel_mode=taxi; _ym_d=1768633598; pi=IreYzr43EfG0juYgSQhfazfgllVLGu+KIEPklNyVkXcsKS8FTD3zNpHvo7vd+EKW1lMXnVwhdG9JW94LcvcqBat/5rI=; alice_uuid=00000000000006087275171752827830; i=vhFXyy8bDKjr1ayGpmbOn7gnYPP9xMQ27pwalJakDrkvUxI6Sbb1WWHXagHm4l/hIorv+YQt50iP2VwzuV4bkalKRsQ=; Session_id=3:1774691235.5.0.1752846693118:4VxQXQ:6ee7.1.2:1|1065437057.-1.2.3:1752846693|1130000069850438.-1.0.2:5512777.3:1758359470|3:11804080.603152.bE4GPj6Z5_x1_apuPNyl8MH7ZaI; sessar=1.1719225.CiBh7QmiWzz-9PYqgfr0SkVcU1rJDPyZ8LHXk2sxuW4vbw.Q290uyXqh7BhbB3LB2dXPM_kMFOF29VfFSE_ZnK2bs4; sessionid2=3:1774691235.5.0.1752846693118:4VxQXQ:6ee7.1.2:1|1065437057.-1.2.3:1752846693|1130000069850438.-1.0.2:5512777.3:1758359470|3:11804080.603152.fakesign0000000000000000000; alice_reqids=1774709497182232-1163570016191394610-ittgpzle4vntzhpq-BAL.1774709497~1774533323399036-7971548315767080288-b6xxvxwnwibtwwlz-BAL.1774533323; isa=mWc9211eVEDkxcgRz4yNmOwHzgrUVgtR14yqrdM+Hl94CmHL79rpFqmPg4wXGH0n/tSm6BfAm4aNto21QUoBLiUCgSY=; _ym_isad=1; cycada=iCMqnoFe07FjPJPGd1ib28D44u0Lm/g+pSN2ZzpPhK0=; instruction=1; _yasc=P5rRLkn6qmIeVJX34hVOhGHcaYFvipMNmyJ7h/uxIAE9CJfhzmfjOCIMOyxCQTMHk5A9iViAK9nQkD7+W9NF2t3AbiMUiZ4eTPPlp7yxlq0IEEYRrwZqWHcJCa7ruianhNj+JfkdGkp6o2J6NX1BABhZb3xayRsp; yandex_expboxes=1512060%2C0%2C42%3B1508403%2C0%2C45%3B1497450%2C0%2C92%3B1494508%2C0%2C39%3B1515148%2C0%2C77%3B1502455%2C0%2C74%3B1509088%2C0%2C23%3B663874%2C0%2C3%3B663860%2C0%2C5%3B1257223%2C0%2C55%3B1493182%2C0%2C75%3B1513991%2C0%2C82; ys=def_bro.0#ead.2FECB7CF#newsca.native_cache#wprid.1774770367790762-8169781372234682266-balancer-l7leveler-kubr-yp-sas-116-BAL#ybzcc.ru; maps_session_id=1774770429777720-11067840316453735157-balancer-l7leveler-kubr-yp-klg-9-BAL; gpauto=55_742655:49_182048:77:0:1774770425; gpb=gpauto.55_742655%3A49_182048%3A77%3A0%3A1774770425; yp=1800104567.bk-map.1#1784393554.cld.2378379-1#1790872906.dafs.31-3#1784457993.dc_neuro.10#1775233628.dlp.1#1774854598.duc.ru#1774777676.gpauto.55_742655:49_182048:77:0:1774770425#1776846545.hdrc.1#2073719470.multib.1#2090130404.pcs.0#2068211437.skin.d#1802969945.swntab.104894032#1785797766.szm.1_25:1536x960:1521x832:15#1774854598.uc.ru#2073722641.udn.cDrQkNC70ZHQvdCw; bh=Ek8iTm90KEE6QnJhbmQiO3Y9IjgiLCAiQ2hyb21pdW0iO3Y9IjE0NCIsICJZYUJyb3dzZXIiO3Y9IjI2LjMiLCAiWW93c2VyIjt2PSIyLjUiGgUieDg2IiIMIjI2LjMuMS45ODEiKgI/MDICIiI6CSJXaW5kb3dzIkIIIjE1LjAuMCJKBCI2NCJSZiJOb3QoQTpCcmFuZCI7dj0iOC4wLjAuMCIsICJDaHJvbWl1bSI7dj0iMTQ0LjAuNzU1OS45ODEiLCAiWWFCcm93c2VyIjt2PSIyNi4zLjEuOTgxIiwgIllvd3NlciI7dj0iMi41IloCPzBghLKjzgZqIdzK4f8IktihsQOfz+HqA/v68OcN6//99g+e982UB/OBAg==")
                    .build();

            // Отправляем запрос и получаем ответ
            HttpResponse<String> response = client.send(
                    request,
                    HttpResponse.BodyHandlers.ofString()
            );

            // Получаем статус и тело ответа
            //System.out.println("Status: " + response.statusCode());

            String body = response.body();

            //System.out.println("Body: " + response.body());

            ObjectMapper mapper = new ObjectMapper();

            Vehicles vehicles = mapper.readValue(body, Vehicles.class);


            //1. Вывести номера маршрутов и кол-во транспорта на каждом
            vehicles.getData().getVehicles().stream().collect(Collectors.toMap(
                    b -> b.getProperties().getVehicleMetaData().getTransport().getName(),
                    b -> 1,
                    (a,b) -> a + b
            )).forEach((a,b) -> System.out.println(a + " - " + b));
            System.out.println();

            //2. Вывести номер маршрута и список координат транспорта на маршруте
            vehicles.getData().getVehicles()
                    .forEach(a -> System.out.println(a.getProperties().getVehicleMetaData().getTransport().getName() + " - " + Arrays.toString(a.getFeatures().getLast().getGeometry().getCoordinates().getLast())));
            System.out.println();

            //4. Найти ближайший автобус по выбранным координатам
            List<Double> coord = new ArrayList<>(List.of(49.345,49.99));
            String name = vehicles.getData().getVehicles().stream()
                    .min((a,b) -> (int) (Math.sqrt(Math.pow(coord.getFirst() - a.getFeatures().getLast().getGeometry().getCoordinates().getLast()[0],2)
                                        + Math.pow(coord.getLast() - a.getFeatures().getLast().getGeometry().getCoordinates().getLast()[1],2))
                                        - Math.sqrt(Math.pow(coord.getFirst() - b.getFeatures().getLast().getGeometry().getCoordinates().getLast()[0],2)
                                        + Math.pow(coord.getLast() - b.getFeatures().getLast().getGeometry().getCoordinates().getLast()[1],2))))
                    .map(a -> a.getProperties().getVehicleMetaData().getTransport().getName()).get();
            System.out.println(name);



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}