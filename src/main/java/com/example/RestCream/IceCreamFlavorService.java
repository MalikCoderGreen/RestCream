package com.example.RestCream;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class IceCreamFlavorService {
    private final IcecreamFlavorRepository icecreamFlavorRepository;
    public IceCreamFlavorService (IcecreamFlavorRepository icecreamFlavorRepository) {
        this.icecreamFlavorRepository = icecreamFlavorRepository;
    }

    public void insertIceCreamFlavor(IceCreamFlavor iceCreamFlavor) {
        icecreamFlavorRepository.save(iceCreamFlavor);
    }

    public List<IceCreamFlavor> getAllIceCreamFlavors() {
        return icecreamFlavorRepository.findAll();
    }

    public IceCreamFlavor getIceCreamFlavorById(Integer id) {
        return icecreamFlavorRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(id + " not found"));
    }
}