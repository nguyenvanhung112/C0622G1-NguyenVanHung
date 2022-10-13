package currency.service;

import org.springframework.stereotype.Service;

@Service
public class ConvertService implements IConvertService {
    @Override
    public double convert(double usd) {
        return usd*23000;
    }
}
