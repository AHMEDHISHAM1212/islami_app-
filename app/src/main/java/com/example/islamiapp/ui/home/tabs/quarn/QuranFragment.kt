package com.example.islamiapp.ui.home.tabs.quarn

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.islamiapp.databinding.FragmentQuranBinding
import com.example.islamiapp.ui.Constants.Constant
import com.example.islamiapp.ui.SuraDetails.SuraDetailsActivity
import com.example.islamiapp.ui.model.Sura

class QuranFragment : Fragment() {
    private val TAG = "QuranFragment"
    private lateinit var viewBinding: FragmentQuranBinding

    private var suraName = listOf(
        "الفاتحه",
        "البقرة",
        "آل عمران",
        "النساء",
        "المائدة",
        "الأنعام",
        "الأعراف",
        "الأنفال",
        "التوبة",
        "يونس",
        "هود",
        "يوسف",
        "الرعد",
        "إبراهيم",
        "الحجر",
        "النحل",
        "الإسراء",
        "الكهف",
        "مريم",
        "طه",
        "الأنبياء",
        "الحج",
        "المؤمنون",
        "النّور",
        "الفرقان",
        "الشعراء",
        "النّمل",
        "القصص",
        "العنكبوت",
        "الرّوم",
        "لقمان",
        "السجدة",
        "الأحزاب",
        "سبأ",
        "فاطر",
        "يس",
        "الصافات",
        "ص",
        "الزمر",
        "غافر",
        "فصّلت",
        "الشورى",
        "الزخرف",
        "الدّخان",
        "الجاثية",
        "الأحقاف",
        "محمد",
        "الفتح",
        "الحجرات",
        "ق",
        "الذاريات",
        "الطور",
        "النجم",
        "القمر",
        "الرحمن",
        "الواقعة",
        "الحديد",
        "المجادلة",
        "الحشر",
        "الممتحنة",
        "الصف",
        "الجمعة",
        "المنافقون",
        "التغابن",
        "الطلاق",
        "التحريم",
        "الملك",
        "القلم",
        "الحاقة",
        "المعارج",
        "نوح",
        "الجن",
        "المزّمّل",
        "المدّثر",
        "القيامة",
        "الإنسان",
        "المرسلات",
        "النبأ",
        "النازعات",
        "عبس",
        "التكوير",
        "الإنفطار",
        "المطفّفين",
        "الإنشقاق",
        "البروج",
        "الطارق",
        "الأعلى",
        "الغاشية",
        "الفجر",
        "البلد",
        "الشمس",
        "الليل",
        "الضحى",
        "الشرح",
        "التين",
        "العلق",
        "القدر",
        "البينة",
        "الزلزلة",
        "العاديات",
        "القارعة",
        "التكاثر",
        "العصر",
        "الهمزة",
        "الفيل",
        "قريش",
        "الماعون",
        "الكوثر",
        "الكافرون",
        "النصر",
        "المسد",
        "الإخلاص",
        "الفلق",
        "الناس"
    )
    private var suraPosition = listOf(
        "7",
        "286",
        "200",
        "176",
        "120",
        "165",
        "206",
        "75",
        "129",
        "109",
        "123",
        "111",
        "43",
        "52",
        "99",
        "128",
        "111",
        "110",
        "98",
        "135",
        "112",
        "78",
        "118",
        "64",
        "77",
        "227",
        "93",
        "88",
        "69",
        "60",
        "34",
        "30",
        "73",
        "54",
        "45",
        "83",
        "182",
        "88",
        "75",
        "85",
        "54",
        "53",
        "89",
        "59",
        "37",
        "35",
        "38",
        "29",
        "18",
        "45",
        "360",
        "49",
        "62",
        "55",
        "78",
        "96",
        "29",
        "22",
        "24",
        "13",
        "14",
        "11",
        "11",
        "18",
        "12",
        "12",
        "30",
        "52",
        "44",
        "28",
        "20",
        "56",
        "40",
        "31",
        "50",
        "40",
        "46",
        "42",
        "29",
        "19",
        "36",
        "25",
        "22",
        "17",
        "19",
        "26",
        "30",
        "20",
        "15",
        "21",
        "11",
        "8",
        "8",
        "19",
        "5",
        "8",
        "11",
        "11",
        "8",
        "3",
        "9",
        "5",
        "4",
        "7",
        "3",
        "6",
        "3",
        "5",
        "4",
        "5",
        "6"
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentQuranBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        intiRecyclerView()
    }

    lateinit var adapter: ChapterNameAdapter
    private fun intiRecyclerView() {
        adapter = ChapterNameAdapter(suraName.mapIndexed { position, name ->
            Sura(name, position + 1)

        })
        viewBinding.rvSuraName.adapter = adapter
        adapterClickListener()
    }


    private fun adapterClickListener() {
        adapter.onItemClickListener =
            ChapterNameAdapter.OnItemClickListener { position, Sura ->
                Log.e(TAG, Sura.suraName)
                Log.e(TAG, position.toString())
                var intent = Intent(activity, SuraDetailsActivity::class.java)
                intent.putExtra("suraName", Sura.suraName)
                intent.putExtra(Constant.SURA_POSITION_KEY, position)
                startActivity(intent)
            }

    }

}