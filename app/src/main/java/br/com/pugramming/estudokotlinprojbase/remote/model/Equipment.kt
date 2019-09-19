package br.com.pugramming.estudokotlinprojbase.remote.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Equipment(
    val category: String,
    val description: String
    //val equipmentMap:Map<String,String> = {
        //return map
    //}
):Parcelable


/*
.joinToString(“ “) -  Junta todos elementos de uma lista, usando o que for passado como parâmetro
 como divisor, nesse caso espaço.


ArrayList<Equipments> arrayEquipments = new ArrayList<>();
            HashMap<String, String> equipmentsHash = new HashMap<>();
            Map<String, String> result = new HashMap<String, String>();

            if(car.getEquipments()!=null && car.getEquipments().size()>0) {
                //Cria Hashmap com K/V - Category/Description
                for (Equipments eq : car.getEquipments()) {
                    equipmentsHash.put(eq.getDescription(), eq.getCategory());
                }

                //Agrupa por Category
                for(Map.Entry<String,String> entry : equipmentsHash.entrySet()){
                    String details = "";
                    if(result.containsKey(entry.getValue()))
                        details += result.get(entry.getValue());
                    details += entry.getKey()+", ";
                    result.put(entry.getValue(), details);
                }

                //Atualiza o model com os dados filtrados
                for(Map.Entry entry: result.entrySet()){
                    String category = entry.getKey().toString().toUpperCase();
                    String description = entry.getValue().toString();

                    //Remove vírgula extra no final da String
                    if(description.endsWith(", ")){
                        description = description.substring(0, description.length() - 2);
                    }

                    arrayEquipments.add(new Equipments(category, description));
                }

                car.setEquipments(arrayEquipments);
            }
            carList.add(car);










 */
