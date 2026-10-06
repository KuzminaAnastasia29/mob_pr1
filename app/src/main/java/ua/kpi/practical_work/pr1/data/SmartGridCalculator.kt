package ua.kpi.practical_work.pr1.data

class SmartGridCalculator {
    /**
     * Розраховує необхідну потужність мережі.
     * @param load Загальне навантаження споживачів (кВт)
     * @param efficiency Ефективність ліній електропередач (%)
     * @param reserve Резервна потужність (%)
     */
    fun calculateRequiredPower(load: String, efficiency: String, reserve: String): Double {
        val l = load.toDoubleOrNull() ?: 0.0
        // Ділимо на 100 для отримання відсотка. Якщо введено 0 або помилку, ставимо 1.0 (100%), щоб уникнути ділення на нуль
        val eff = efficiency.toDoubleOrNull()?.let { if (it > 0) it / 100 else 1.0 } ?: 1.0
        val res = reserve.toDoubleOrNull()?.div(100) ?: 0.0

        // Формула: (Навантаження / Ефективність) * (1 + Резерв)
        return (l / eff) * (1 + res)
    }
}