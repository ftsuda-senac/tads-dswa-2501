/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package br.senac.tads.dsw.exemplo1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.MessageFormat;

@Controller
public class ExemploController {

//    @GetMapping(produces = "text/html")
//    @ResponseBody
//    public String exemplo(
//            @RequestParam(name = "nome", defaultValue = "usuário") String nome,
//            @RequestHeader("user-agent") String userAgent) {
//        String htmlTemplate =  """
//               <!doctype html>
//               <html>
//                 <head>
//                   <meta charset="utf-8" />
//                   <title>Exemplo Spring Boot</title>
//                 </head>
//                 <body>
//                   <h1>Exemplo Spring Boot</h1>
//                   <h2>Olá {0}</h2>
//                   <p>User-agent: <code>{1}</code></p>
//                 </body>
//               </html>
//               """;
//        return MessageFormat.format(htmlTemplate.replace("'", "''"),
//                nome, userAgent);
//    }

    @GetMapping(produces = "application/json")
    @ResponseBody
    public String exemplo(
            @RequestParam(name = "nome", defaultValue = "usuário") String nome,
            @RequestHeader("user-agent") String userAgent) {
        String jsonTemplate =  """
               '{'
                  "nome": "{0}",
                  "userAgent": "{1}"
               '}'
               """;
        return MessageFormat.format(jsonTemplate, nome, userAgent);
    }

}
