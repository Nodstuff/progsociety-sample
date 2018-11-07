package app.controller

import app.model.Salutation
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController
class SalutationController {

    val counter = AtomicLong()
    val salutations = ArrayList<Salutation>()

    @GetMapping("/salutation")
    fun greeting(@RequestParam(value = "name", defaultValue = "Fellow") name: String): Salutation {
        salutations.add(Salutation(counter.incrementAndGet(), "Hail, $name, well met!"))
        return salutations.last()
    }

    @GetMapping("/salutations")
    fun getSalutations(): List<Salutation> {
        return salutations
    }
}