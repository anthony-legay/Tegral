/*
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

package guru.zoroark.tegral.web.controllers

import io.ktor.server.application.Application
import io.ktor.server.routing.Routing
import io.ktor.server.routing.routing

/**
 * Identical to [KtorModule], but allows you to directly add routes, as if calling `routing` in a [KtorModule].
 */
abstract class KtorController(priority: Int = DEFAULT_CONTROLLER_PRIORITY, restrictToAppName: String? = null) :
    KtorModule(priority, restrictToAppName) {
    /**
     * Install this controller's routes. You can call `route`, `get`, etc here.
     */
    abstract fun Routing.install()

    override fun Application.install() {
        routing { install() }
    }
}
