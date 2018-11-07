package app.controller

import app.model.Other
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController
class OtherController {

    val counter = AtomicLong()
    val others = ArrayList<Other>()

    @GetMapping("/other")
    fun greeting(@RequestParam(value = "item", defaultValue = "apples") item: String): Other {
        others.add(Other(counter.incrementAndGet(), "Will you pick me up some $item, please."))
        return others.last()
    }

    @GetMapping("/others")
    fun getOthers(): List<Other> {
        return others
    }
}