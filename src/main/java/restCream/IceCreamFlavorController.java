package restCream;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api")
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

    @PutMapping("{id}")
    public ResponseEntity<IceCreamFlavor> updateIceCreamFlavor(@PathVariable("id") Integer id, @Valid @RequestBody IceCreamFlavor updatedIceCreamEntry) {
        return iceCreamFlavorService.updateIceCreamFlavor(id, updatedIceCreamEntry);
    }

    @DeleteMapping("delete/flavor/{id}")
    public ResponseEntity<HttpStatus> deleteIceCreamFlavorById(@PathVariable("id") Integer id) {
        return iceCreamFlavorService.deleteIceCreamFlavorById(id);
    }
}
