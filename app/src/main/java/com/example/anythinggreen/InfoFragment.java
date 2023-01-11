package com.example.anythinggreen;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class InfoFragment extends Fragment {

    ImageView material_img;
    TextView material_type, years, made_of, recycle_ways, mat_desc;
    String material;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_info, container, false);

        material_img = view.findViewById(R.id.material_img);
        material_type = view.findViewById(R.id.material_type);
        years = view.findViewById(R.id.years);
        made_of = view.findViewById(R.id.made_of);
        recycle_ways = view.findViewById(R.id.recycle_ways);
        mat_desc = view.findViewById(R.id.mat_desc);

        return view;
    }

    // Use the onViewCreated method to initialize the TextView and observe the value of the TextView as it is ran after view is created
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Get a reference to the view model
        SharedViewModel viewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        // Observe changes MutableLiveData<String> classification
        viewModel.getClassification().observe(getViewLifecycleOwner(), value -> {
            // Store value to String material
            material = value;
            // Set String material as text to material_type TextView
            material_type.setText(material);
            // Provide information about material type
            provideInformation();
        });

        // Observe changes MutableLiveData<Bitmap> imageClassified
        viewModel.getImageClassified().observe(getViewLifecycleOwner(), bitmap -> {
            // Set Bitmap bitmap as material_img ImageView
            material_img.setImageBitmap(bitmap);
        });
    }

    private void provideInformation() {
        // If material is plastic
        switch (material) {
            case "Plastic":
                years.setText("hundred of years");
                made_of.setText("variety of monomers");
                recycle_ways.setText("1. Use reusable bags, containers, and water bottles: Using reusable bags, containers, and water bottles can help to reduce the amount of plastic that you use and dispose of." + "\n" + "\n" +
                        "2. Recycle your plastic: Many communities have recycling programs that allow residents to recycle plastic items like bottles, containers, and packaging. Check with your local government or waste management provider to find out what types of plastic are accepted for recycling in your area." + "\n" + "\n" +
                        "3. Properly dispose of plastic: If an item is not recyclable, be sure to properly dispose of it in a garbage bin. Do not litter, as this can contribute to plastic pollution in the environment." + "\n" + "\n" +
                        "4. Buy products made from recycled plastic: Choosing products that are made from recycled plastic can help to support the recycling industry and reduce the demand for new plastic." + "\n" + "\n" +
                        "5. Reduce your plastic consumption: One of the most effective ways to reduce the environmental impact of plastic is to simply use less of it. Look for opportunities to reduce your plastic consumption, such as by choosing products with minimal packaging or opting for reusable options instead of disposable ones.");
                mat_desc.setText("• Plastic waste is a major environmental problem, with millions of tons of plastic being produced and discarded every year." + "\n" + "\n" +
                        "• Only a small fraction of plastic is recycled, with the majority ending up in landfills or the environment." + "\n" + "\n" +
                        "• Plastic pollution is a global problem, with plastic debris found in every corner of the world, including the most remote areas of the planet." + "\n" + "\n" +
                        "• Plastic pollution can have serious impacts on wildlife, including entanglement, ingestion, and habitat destruction." + "\n" + "\n" +
                        "• Recycling plastic can help to conserve resources and reduce the environmental impacts of plastic production and disposal." + "\n" + "\n" +
                        "• Some alternatives to plastic, such as bioplastics and plant-based plastics, are being developed as more sustainable options." + "\n" + "\n" +
                        "• Reducing our use of plastic and properly disposing of it is important for minimizing the environmental impact of plastic." + "\n" + "\n" +
                        "• There are many ways to reduce plastic waste, including using reusable bags, containers, and water bottles, and properly disposing of plastic items." + "\n" + "\n" +
                        "• Individual actions, such as reducing plastic consumption and properly disposing of plastic waste, can make a big difference in the fight against plastic pollution.");
                break;

            // If material is e-waste
            case "E-waste":
                years.setText("hundred of years");
                made_of.setText("metals, plastics, glass, hazardous materials");
                recycle_ways.setText("1. Donate or sell: If your electronic device is still in good working condition, you may be able to donate it or sell it to someone who can continue to use it. This can help extend the life of the device and reduce the demand for new products." + "\n" + "\n" +
                        "2. Recycle: Many communities have programs in place for recycling e-waste. These programs typically collect electronic devices and send them to specialized facilities where they are dismantled and the materials are recovered and recycled." + "\n" + "\n" +
                        "3. Mail-in programs: Some companies offer mail-in programs that allow you to send in your e-waste for proper recycling." + "\n" + "\n" +
                        "4. Electronic waste drop-off centers: Some communities have designated drop-off centers where residents can bring their e-waste for proper recycling." + "\n" + "\n" +
                        "5. Retail drop-off programs: Some electronics retailers offer e-waste recycling programs and will accept e-waste at their stores.");
                mat_desc.setText("• E-waste is the fastest-growing waste stream in the world. The volume of e-waste generated globally is expected to reach 93.5 million metric tons by 2030." + "\n" + "\n" +
                        "• Only a small percentage of e-waste is properly recycled. It is estimated that only about 20% of e-waste is recycled globally, while the rest is either landfilled or informally recycled in developing countries." + "\n" + "\n" +
                        "• E-waste contains valuable materials that can be recovered and reused. For example, a single cell phone can contain gold, silver, and copper, which can be recovered and used to make new products." + "\n" + "\n" +
                        "• E-waste can be hazardous to the environment and human health if not properly disposed of. Many e-waste items contain hazardous materials, such as lead, mercury, and cadmium, which can have negative impacts if they are not properly managed." + "\n" + "\n" +
                        "• Proper e-waste recycling can help conserve natural resources and reduce the demand for new raw materials. By recycling e-waste, we can recover valuable materials that can be used to make new products, reducing the need to extract these materials from the earth." + "\n" + "\n" +
                        "• There are various options for disposing of e-waste, including donation, recycling, and mail-in programs. It is important to properly dispose of e-waste in order to minimize its negative impacts on the environment and to conserve valuable resources.");
                break;

            // If material is glass
            case "Glass":
                years.setText("does not decompose");
                made_of.setText("silica, soda ash, limestone, sand");
                recycle_ways.setText("1. Curbside recycling: Many communities offer curbside recycling programs where residents can place their recyclable materials in a designated container, which is then collected by a recycling truck and taken to a recycling facility. Glass can typically be placed in a separate container or mixed in with other recyclable materials." + "\n" + "\n" +
                        "2. Drop-off recycling centers: Many communities have drop-off recycling centers where residents can bring their recyclable materials to be processed. These centers often accept a wider range of materials than curbside recycling programs and may be able to recycle items that cannot be recycled through curbside programs." + "\n" + "\n" +
                        "3. Buyback centers: Some recycling centers will pay for certain recyclable materials, such as aluminum cans and certain types of plastic. Glass is often not included in these buyback programs, but it can still be recycled through other methods." + "\n" + "\n" +
                        "4. Glass bottle banks: Many communities have designated glass bottle banks where residents can deposit their used glass bottles and jars for recycling. These bottle banks are typically located in convenient locations, such as grocery store parking lots, and are often operated by local authorities or charitable organizations." + "\n" + "\n" +
                        "5. Private recycling companies: There are also private companies that specialize in recycling glass and other materials. These companies often accept a wide range of materials and may offer pickup services for larger quantities of glass.");
                mat_desc.setText("• Glass is 100% recyclable and can be recycled indefinitely without losing quality. This makes it an important material for waste management and resource conservation." + "\n" + "\n" +
                        "• Glass recycling saves energy compared to producing new glass from raw materials. It takes less energy to melt down and reuse recycled glass than it does to extract, process, and melt raw materials to make new glass." + "\n" + "\n" +
                        "• Glass can be recycled into new glass containers or used as an aggregate in construction materials, such as concrete or asphalt." + "\n" + "\n" +
                        "• Glass recycling helps to reduce greenhouse gas emissions by reducing the need to extract, process, and transport raw materials." + "\n" + "\n" +
                        "• Glass that is not recycled often ends up in landfills, where it can take up space and potentially contribute to pollution. Glass that is sent to a landfill does not decompose or break down naturally, so it can remain there indefinitely.");
                break;

            // If material is metal
            case "Metal":
                years.setText("does not decompose but may corrode");
                made_of.setText("found in nature");
                recycle_ways.setText("1. Melting and casting: One of the most common methods of metal recycling is to melt the metal down and then cast it into a new product. This process is called smelting. It involves heating the metal to a high temperature to separate it from impurities and then pouring it into a mold to form a new shape." + "\n" + "\n" +
                        "2. Shredding and separating: Another method of metal recycling involves shredding the metal into small pieces and then separating the different types of metal using a process called eddy current separation. This method is often used for recycling electronic waste, as it allows for the separation of different types of metal, such as copper, aluminum, and brass." + "\n" + "\n" +
                        "3. Reusing metal products: In some cases, it may be possible to reuse metal products without having to recycle them. For example, if a metal product is in good condition, it may be sold or donated to someone who can use it." + "\n" + "\n" +
                        "4. Donating metal: Scrap metal can be donated to organizations that collect and recycle it. These organizations may include scrap metal dealers, recycling centers, and charitable organizations.");
                mat_desc.setText("• Metal is one of the most commonly recycled materials in the world. It is estimated that around two-thirds of all metal production globally comes from recycled metal." + "\n" + "\n" +
                        "• Metal recycling conserves natural resources, such as ore and water, and reduces energy consumption. It takes significantly less energy to produce metal from recycled material than from raw ore." + "\n" + "\n" +
                        "• Metal recycling also reduces greenhouse gas emissions. The production of metal from ore generates large amounts of greenhouse gases, while recycling metal generates significantly fewer emissions." + "\n" + "\n" +
                        "• Many metal products, such as cars, appliances, and electronic devices, can be recycled multiple times without losing quality." + "\n" + "\n" +
                        "• Metal recycling can be an important source of income for individuals and organizations. Scrap metal can be sold to metal recycling facilities, which pay for it based on the type and weight of the metal." + "\n" + "\n" +
                        "• Metal waste, such as abandoned cars and appliances, can be a significant source of pollution and an eyesore in communities. Properly disposing of these items through recycling can help to improve the appearance and environmental health of an area.");
                break;

            // If material is paper
            case "Paper":
                years.setText("few weeks to several years");
                made_of.setText("wood pulp");
                recycle_ways.setText("1. Curbside recycling: Many communities have curbside recycling programs that allow residents to place their recyclables in a designated bin for collection. Paper products, including newspaper, cardboard, office paper, and envelopes, can typically be placed in these bins." + "\n" + "\n" +
                        "2. Drop-off recycling centers: Some communities have drop-off recycling centers where residents can bring their recyclables to be sorted and processed. These centers often accept a wider range of paper products than curbside programs." + "\n" + "\n" +
                        "3. Commercial recycling programs: Many businesses and organizations have their own recycling programs in place to recycle the paper products they generate." + "\n" + "\n" +
                        "4. Composting: Some paper products, such as newspaper and cardboard, can be composted along with yard trimmings and food waste to create a nutrient-rich soil amendment." + "\n" + "\n" +
                        "5. Reuse: One of the most effective ways to recycle paper is to reuse it. For example, you can use both sides of a piece of paper before disposing of it, or you can recycle old notebooks by tearing out the used pages and using the remaining blank pages for notes or drawings.");
                mat_desc.setText("• Recycling paper can help to conserve natural resources. It takes about 70% less energy to produce recycled paper compared to paper made from virgin wood pulp." + "\n" + "\n" +
                        "• In addition to conserving energy, recycling paper can also help to reduce greenhouse gas emissions. The production of paper from virgin wood pulp is a major source of carbon dioxide emissions, but recycling paper can help to offset these emissions." + "\n" + "\n" +
                        "• There are many different types of paper products that can be recycled, including office paper, newspaper, cardboard, envelopes, and paperboard." + "\n" + "\n" +
                        "• There are also a variety of other materials that can be recycled along with paper, including aluminum cans, plastic bottles, and glass bottles. By recycling a mix of materials, we can further reduce waste and conserve natural resources.");
                break;

            // If material is clothes
            case "Clothes":
                years.setText("3 months to 50 years");
                made_of.setText("cotton, wool, linen, silk, polyester, nylon, acrylic, leather, rubber");
                recycle_ways.setText("1. Donate gently used clothes to a thrift store or charitable organization. Many organizations accept donations of gently used clothes and other household items, and these items can then be sold or given to people in need." + "\n" + "\n" +
                        "2. Sell or trade clothes with friends or through online platforms. There are many online platforms, such as Poshmark and Depop, that allow you to sell or trade gently used clothes with other people." + "\n" + "\n" +
                        "3. Repurpose old clothes into new items. Instead of throwing away old clothes, you can repurpose them into something new, such as turning an old t-shirt into a tote bag or a pair of jeans into a skirt." + "\n" + "\n" +
                        "4. Send clothes to a textile recycling facility. Textile recycling facilities can turn old clothes into new products, such as insulation, rags, or new clothing." + "\n" + "\n" +
                        "5. Use clothes as rags or cleaning cloths. Instead of throwing away old clothes, you can use them as rags or cleaning cloths around the house.");
                mat_desc.setText("• The fashion industry is one of the largest polluting industries in the world. The production and disposal of clothes contribute to air, water, and soil pollution, as well as greenhouse gas emissions." + "\n" + "\n" +
                        "• Textile waste is a significant contributor to climate change. The production and disposal of clothes generates greenhouse gas emissions, and the decomposition of textiles in landfills releases methane, a potent greenhouse gas." + "\n" + "\n" +
                        "• Recycling clothes can help to reduce waste and the environmental impact of the fashion industry. Textile recycling facilities can turn old clothes into new products, such as insulation, rags, or new clothing." + "\n" + "\n" +
                        "• Buying secondhand clothes or clothing made from sustainable materials can also help to reduce the environmental impact of the fashion industry. Many thrift stores and online platforms offer gently used clothes, and there are also many brands that offer clothing made from sustainable materials, such as organic cotton or recycled polyester.");
                break;

            // If material is non-recyclable
            default:
                years.setText("Unknown");
                made_of.setText("Unknown");
                recycle_ways.setText("The scanned material is not recyclable. It can either be classified as biodegradable or non-biodegradable waste depending on its composition.");
                mat_desc.setText("• Biodegradable waste refers to materials that can be broken down, decomposed and returned to the environment by natural processes. Examples include food scraps, yard waste, and paper products." + "\n" + "\n" +
                            "• Non-biodegradable waste refers to materials that do not break down and cannot be returned to the environment by natural processes. Examples include plastic, metal, and glass.");
                break;
        }
    }
}