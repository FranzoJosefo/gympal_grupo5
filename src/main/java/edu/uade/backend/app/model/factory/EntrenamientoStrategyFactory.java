package edu.uade.backend.app.model.factory;

import edu.uade.backend.app.model.enums.ObjetivoTipo;
import edu.uade.backend.app.model.strategies.BajarEntrenamientoStrategy;
import edu.uade.backend.app.model.strategies.IEntrenamientoStrategy;
import edu.uade.backend.app.model.strategies.MantenerEntrenamientoStrategy;
import edu.uade.backend.app.model.strategies.TonificarEntrenamientoStrategy;

public class EntrenamientoStrategyFactory {

    public IEntrenamientoStrategy getEntrenamientoStrategy(ObjetivoTipo objetivoTipo) {
        IEntrenamientoStrategy strategy = null;
        switch (objetivoTipo) {
            case MANTENER: {
                strategy = new MantenerEntrenamientoStrategy();
                break;
            }
            case TONIFICAR: {
                strategy = new TonificarEntrenamientoStrategy();
                break;
            }
            case BAJAR_PESO: {
                strategy = new BajarEntrenamientoStrategy();
                break;
            }
        }
        return strategy;
    }

}
