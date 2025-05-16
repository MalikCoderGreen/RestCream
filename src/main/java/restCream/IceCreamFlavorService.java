package restCream;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class IceCreamFlavorService {
    private final IcecreamFlavorRepository icecreamFlavorRepository;
    public IceCreamFlavorService (IcecreamFlavorRepository icecreamFlavorRepository) {
        this.icecreamFlavorRepository = icecreamFlavorRepository;
    }

    public void insertIceCreamFlavor(IceCreamFlavor iceCreamFlavor) {
        icecreamFlavorRepository.save(iceCreamFlavor);
    }

    public ResponseEntity<HttpStatus> deleteIceCreamFlavorById(Integer id) {
        try {
            icecreamFlavorRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public List<IceCreamFlavor> getAllIceCreamFlavors() {
        return icecreamFlavorRepository.findAll();
    }

    public IceCreamFlavor getIceCreamFlavorById(Integer id) {
        return icecreamFlavorRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(id + " not found"));
    }

    public ResponseEntity<IceCreamFlavor> updateIceCreamFlavor(Integer id, IceCreamFlavor updatedIceCreamEntry) {
        Optional<IceCreamFlavor> existingIceCreamEntry = icecreamFlavorRepository.findById(id);
        if (existingIceCreamEntry.isPresent()) {
              IceCreamFlavor existingFlavor = existingIceCreamEntry.get();
              existingFlavor.setIceCreamFlavor(updatedIceCreamEntry.getIceCreamFlavor());
              existingFlavor.setBrand(updatedIceCreamEntry.getBrand());
              existingFlavor.setPrice(updatedIceCreamEntry.getPrice());
              existingFlavor.setSeasonal(updatedIceCreamEntry.isSeasonal());
              existingFlavor.setVegan(updatedIceCreamEntry.isVegan());
            
              return new ResponseEntity<>(icecreamFlavorRepository.save(existingFlavor), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}