/**
 * Copyright (C) 2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package conf;


import ninja.AssetsController;
import ninja.Router;
import ninja.application.ApplicationRoutes;
import controllers.ApplicationController;

public class Routes implements ApplicationRoutes {

    @Override
    public void init(Router router) {  
        
        router.GET().route("/").with(ApplicationController.class, "index");
//      router.GET().route("/hello_world.json").with(ApplicationController.class, "helloWorldJson");
        router.GET().route("/EnglishAcesUp").with(ApplicationController.class, "acesUpEnglish");
        router.GET().route("/SpanishAcesUp").with(ApplicationController.class, "acesUpSpanish");
        router.GET().route("/gameEnglish").with(ApplicationController.class, "gameGetEnglish");
        router.GET().route("/gameSpanish").with(ApplicationController.class, "gameGetSpanish");
        router.POST().route("/gameNewEnglish").with(ApplicationController.class, "gameResetEnglish");
        router.POST().route("/gameNewSpanish").with(ApplicationController.class, "gameResetSpanish");
        router.POST().route("/dealGameEnglish").with(ApplicationController.class, "dealPostEnglish");
        router.POST().route("/dealGameSpanish").with(ApplicationController.class, "dealPostSpanish");
        router.POST().route("/moveCardEnglish/{columnFrom}/{columnTo}").with(ApplicationController.class, "moveCardEnglish");
        router.POST().route("/moveCardSpanish/{columnFrom}/{columnTo}").with(ApplicationController.class, "moveCardSpanish");
        router.POST().route("/removeCardEnglish/{column}").with(ApplicationController.class, "removeCardEnglish");
        router.POST().route("/removeCardSpanish/{column}").with(ApplicationController.class, "removeCardSpanish");

        ///////////////////////////////////////////////////////////////////////
        // Assets (pictures / javascript)
        ///////////////////////////////////////////////////////////////////////    
        router.GET().route("/assets/webjars/{fileName: .*}").with(AssetsController.class, "serveWebJars");
        router.GET().route("/assets/{fileName: .*}").with(AssetsController.class, "serveStatic");
        
        ///////////////////////////////////////////////////////////////////////
        // Index / Catchall shows index page
        ///////////////////////////////////////////////////////////////////////
//        router.GET().route("/.*").with(ApplicationController.class, "index");
    }

}
