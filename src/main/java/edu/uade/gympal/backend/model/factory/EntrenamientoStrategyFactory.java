package edu.uade.gympal.backend.model.factory;

import edu.uade.gympal.backend.model.enums.ObjetivoTipo;
import edu.uade.gympal.backend.model.strategies.BajarEntrenamientoStrategy;
import edu.uade.gympal.backend.model.strategies.IEntrenamientoStrategy;
import edu.uade.gympal.backend.model.strategies.MantenerEntrenamientoStrategy;
import edu.uade.gympal.backend.model.strategies.TonificarEntrenamientoStrategy;

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
