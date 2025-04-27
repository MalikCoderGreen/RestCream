package com.example.RestCream;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/v1/icecream-flavor")
public class IceCreamFlavorController {
    private final IceCreamFlavorService iceCreamFlavorService;

    public IceCreamFlavorController(IceCreamFlavorService iceCreamFlavorService) {
        this.iceCreamFlavorService = iceCreamFlavorService;
    }

    @GetMapping
    public List<IceCreamFlavor> getFlavors() {
        return iceCreamFlavorService.getAllIceCreamFlavors();
    }

    @GetMapping("{id}")
    public IceCreamFlavor getIceCreamFlavorById(
            @PathVariable Integer id
    ) {
        return iceCreamFlavorService.getIceCreamFlavorById(id);
    }

    @PostMapping
    public void addIceCreamFlavor(@RequestBody IceCreamFlavor iceCreamFlavor) {
        // Use Data Transfer Object (DTO)
        iceCreamFlavorService.insertIceCreamFlavor(iceCreamFlavor);

    }
}
