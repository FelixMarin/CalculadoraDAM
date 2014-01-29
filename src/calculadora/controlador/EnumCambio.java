/*
 * Copyright (C) 2014 Félix Marín Ramírez | felixmurcia@gmail.com
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

/*
 * DOCUMENTACION: http://documentacion-calculadora.tk
 */
package calculadora.controlador;

import calculadora.modelo.ModeloProgramador;
import calculadora.vista.VistaCalcProgramador;

/**
 *
 * @author Félix Marín Ramírez | felixmurcia@gmail.com
 */
public enum EnumCambio {

    /**
     * Enumarado que contiene un método que realiza el cambio de base de decimal
     * a decimal.
     */
    DECDEC {
        @Override
        public void resultadoCambio(VistaCalcProgramador vcProgramador,
                ControlProgramador cProgramador,
                ModeloProgramador mProgramador) {
            cProgramador.setOptionBase(false, true, false, false);
            cProgramador.botonesDec();
            vcProgramador.addTexto(String.valueOf(cProgramador.getAcumulador()));
        }
    },
    /**
     * Enumarado que contiene un método que realiza el cambio de base de decimal
     * a binario.
     */
    DECBIN {
        @Override
        public void resultadoCambio(VistaCalcProgramador vcProgramador,
                ControlProgramador cProgramador,
                ModeloProgramador mProgramador) {
            cProgramador.setOptionBase(false, false, false, true);
            cProgramador.botonesBin();
            String resultadoTransformado = mProgramador
                    .decimalBinario(cProgramador.getAcumulador());
            vcProgramador.addTexto(String.valueOf(resultadoTransformado));
            cProgramador.setAcumulador(resultadoTransformado);
        }
    },
    /**
     * Enumarado que contiene un método que realiza el cambio de base de decimal
     * a octal.
     */
    DECOCT {
        @Override
        public void resultadoCambio(VistaCalcProgramador vcProgramador,
                ControlProgramador cProgramador,
                ModeloProgramador mProgramador) {
            cProgramador.setOptionBase(false, false, true, false);
            cProgramador.botonesOct();
            String resultadoTransformado = mProgramador
                    .decimalOctal(cProgramador.getAcumulador());
            vcProgramador.addTexto(String.valueOf(resultadoTransformado));
            cProgramador.setAcumulador(resultadoTransformado);
        }
    },
    /**
     * Enumarado que contiene un método que realiza el cambio de base de decimal
     * a hexadecimal.
     */
    DECHEX {
        @Override
        public void resultadoCambio(VistaCalcProgramador vcProgramador,
                ControlProgramador cProgramador,
                ModeloProgramador mProgramador) {
            cProgramador.setOptionBase(true, false, false, false);
            cProgramador.activarBotones();
            String resultadoTransformado = mProgramador
                    .decimalHexadecimal(cProgramador.getAcumulador());
            vcProgramador.addTexto(String.valueOf(resultadoTransformado.toUpperCase()));
            cProgramador.setAcumulador(resultadoTransformado);
        }
    },
    /**
     * Enumarado que contiene un método que realiza el cambio de base de
     * hexadecimal a decimal.
     */
    HEXDEC {
        @Override
        public void resultadoCambio(VistaCalcProgramador vcProgramador,
                ControlProgramador cProgramador,
                ModeloProgramador mProgramador) {
            cProgramador.setOptionBase(false, true, false, false);
            cProgramador.botonesDec();
            String resultadoTransformado = mProgramador
                    .hexadecimalDecimal(cProgramador.getAcumulador());
            vcProgramador.addTexto(String.valueOf(resultadoTransformado));
            cProgramador.setAcumulador(resultadoTransformado);
        }
    },
    /**
     * Enumarado que contiene un método que realiza el cambio de base de
     * hexadecimal a binario.
     */
    HEXBIN {
        @Override
        public void resultadoCambio(VistaCalcProgramador vcProgramador,
                ControlProgramador cProgramador,
                ModeloProgramador mProgramador) {
            cProgramador.setOptionBase(false, false, false, true);
            cProgramador.botonesBin();
            String resultadoTransformado = mProgramador
                    .hexadecimalBinario(cProgramador.getAcumulador());
            vcProgramador.addTexto(String.valueOf(resultadoTransformado));
            cProgramador.setAcumulador(resultadoTransformado);
        }
    },
    /**
     * Enumarado que contiene un método que realiza el cambio de base de
     * hexadecimal a ocatal.
     */
    HEXOCT {
        @Override
        public void resultadoCambio(VistaCalcProgramador vcProgramador,
                ControlProgramador cProgramador,
                ModeloProgramador mProgramador) {
            cProgramador.setOptionBase(false, false, true, false);
            cProgramador.botonesOct();
            String resultadoTransformado = mProgramador
                    .hexadecimalOctal(cProgramador.getAcumulador());
            vcProgramador.addTexto(String.valueOf(resultadoTransformado));
            cProgramador.setAcumulador(resultadoTransformado);
        }
    },
    /**
     * Enumarado que contiene un método que realiza el cambio de base de
     * hexadecimal a hexadecimal.
     */
    HEXHEX {
        @Override
        public void resultadoCambio(VistaCalcProgramador vcProgramador,
                ControlProgramador cProgramador,
                ModeloProgramador mProgramador) {
            cProgramador.setOptionBase(true, false, false, false);
            cProgramador.activarBotones();
            vcProgramador.addTexto(String.valueOf(cProgramador.getAcumulador()).toUpperCase());
        }
    },
    /**
     * Enumarado que contiene un método que realiza el cambio de base de octal a
     * decimal.
     */
    OCTDEC {
        @Override
        public void resultadoCambio(VistaCalcProgramador vcProgramador,
                ControlProgramador cProgramador,
                ModeloProgramador mProgramador) {
            cProgramador.setOptionBase(false, true, false, false);
            cProgramador.botonesDec();
            String resultadoTransformado = mProgramador
                    .octalDecimal(cProgramador.getAcumulador());
            vcProgramador.addTexto(String.valueOf(resultadoTransformado));
            cProgramador.setAcumulador(resultadoTransformado);
        }
    },
    /**
     * Enumarado que contiene un método que realiza el cambio de base de octal a
     * binario.
     */
    OCTBIN {
        @Override
        public void resultadoCambio(VistaCalcProgramador vcProgramador,
                ControlProgramador cProgramador,
                ModeloProgramador mProgramador) {
            cProgramador.setOptionBase(false, false, false, true);
            cProgramador.botonesBin();
            String resultadoTransformado = mProgramador
                    .octalBinario(cProgramador.getAcumulador());
            vcProgramador.addTexto(String.valueOf(resultadoTransformado));
            cProgramador.setAcumulador(resultadoTransformado);
        }
    },
    /**
     * Enumarado que contiene un método que realiza el cambio de base de octal a
     * ocatal.
     */
    OCTOCT {
        @Override
        public void resultadoCambio(VistaCalcProgramador vcProgramador,
                ControlProgramador cProgramador,
                ModeloProgramador mProgramador) {
            cProgramador.setOptionBase(false, false, true, false);
            cProgramador.botonesOct();
            vcProgramador.addTexto(String.valueOf(cProgramador.getAcumulador()));
        }
    },
    /**
     * Enumarado que contiene un método que realiza el cambio de base de octal a
     * hexadecimal.
     */
    OCTHEX {
        @Override
        public void resultadoCambio(VistaCalcProgramador vcProgramador,
                ControlProgramador cProgramador,
                ModeloProgramador mProgramador) {
            cProgramador.setOptionBase(true, false, false, false);
            cProgramador.activarBotones();
            String resultadoTransformado = mProgramador
                    .octalHexadecimal(cProgramador.getAcumulador());
            vcProgramador.addTexto(String.valueOf(resultadoTransformado.toUpperCase()));
            cProgramador.setAcumulador(resultadoTransformado.toUpperCase());
        }
    },
    /**
     * Enumarado que contiene un método que realiza el cambio de base de binario
     * a decimal.
     */
    BINDEC {
        @Override
        public void resultadoCambio(VistaCalcProgramador vcProgramador,
                ControlProgramador cProgramador,
                ModeloProgramador mProgramador) {
            cProgramador.setOptionBase(false, true, false, false);
            cProgramador.botonesDec();
            String resultadoTransformado = mProgramador
                    .binarioDecimal(cProgramador.getAcumulador());
            vcProgramador.addTexto(String.valueOf(resultadoTransformado));
            cProgramador.setAcumulador(resultadoTransformado);
        }
    },
    /**
     * Enumarado que contiene un método que realiza el cambio de base de binario
     * a binario.
     */
    BINBIN {
        @Override
        public void resultadoCambio(VistaCalcProgramador vcProgramador,
                ControlProgramador cProgramador,
                ModeloProgramador mProgramador) {
            cProgramador.setOptionBase(false, false, false, true);
            cProgramador.botonesBin();
            vcProgramador.addTexto(String.valueOf(cProgramador.getAcumulador()));
        }
    },
    /**
     * Enumarado que contiene un método que realiza el cambio de base de binario
     * a octal.
     */
    BINOCT {
        @Override
        public void resultadoCambio(VistaCalcProgramador vcProgramador,
                ControlProgramador cProgramador,
                ModeloProgramador mProgramador) {
            cProgramador.setOptionBase(false, false, true, false);
            cProgramador.botonesOct();
            String resultadoTransformado = mProgramador
                    .binarioOctal(cProgramador.getAcumulador());
            vcProgramador.addTexto(String.valueOf(resultadoTransformado));
            cProgramador.setAcumulador(resultadoTransformado);
        }
    },
    /**
     * Enumarado que contiene un método que realiza el cambio de base de binario
     * a hexadecimal.
     */
    BINHEX {
        @Override
        public void resultadoCambio(VistaCalcProgramador vcProgramador,
                ControlProgramador cProgramador,
                ModeloProgramador mProgramador) {
            cProgramador.setOptionBase(true, false, false, false);
            cProgramador.activarBotones();
            String resultadoTransformado = mProgramador
                    .binarioHexadecimal(cProgramador.getAcumulador());
            vcProgramador.addTexto(String.valueOf(resultadoTransformado.toUpperCase()));
            cProgramador.setAcumulador(resultadoTransformado.toUpperCase());
        }
    };

    /**
     * Método abstracto llamado en el cotrolador y que será utilizado para
     * llamar a los métodos de los enumerados.
     *
     * @param vcProgramador Parametro de tipo VistaCalcProgramador.
     * @param cProgramador Parametro de tipo ControlProgramador.
     * @param mProgramador Parametro de tipo ModeloProgramador.
     */
    public abstract void resultadoCambio(VistaCalcProgramador vcProgramador,
            ControlProgramador cProgramador,
            ModeloProgramador mProgramador);
}
