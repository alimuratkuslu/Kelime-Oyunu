package com.kelimeoyunu;

import com.kelimeoyunu.dto.SaveQuestionRequest;
import com.kelimeoyunu.service.QuestionService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {

	private final QuestionService questionService;

	public Application(QuestionService questionService) {
		this.questionService = questionService;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<SaveQuestionRequest> questions = Arrays.asList(

				SaveQuestionRequest.builder().description("Hastane, ev, fabrika gibi yerlerden kullanılmış ve kullanıcının artık işine yaramayan maddelerin tümü").answer("atık").build(),
				SaveQuestionRequest.builder().description("Tüm insanlık için yemek, barınma, ısınma konularında çığır açan bir keşif").answer("ateş").build(),
				SaveQuestionRequest.builder().description("4 litre kadar sıvıyı içinde tutan organımız").answer("mide").build(),
				SaveQuestionRequest.builder().description("Avını, yaşadığı habitattan çekip çıkaran bir av aracı").answer("olta").build(),
				SaveQuestionRequest.builder().description("En gürültülü yağış türü").answer("dolu").build(),
				SaveQuestionRequest.builder().description("Işığın yüzde yüzünü yansıtan cilalı yüzeye sahip optik gereç").answer("ayna").build(),
				SaveQuestionRequest.builder().description("Leylak rengi").answer("lila").build(),
				SaveQuestionRequest.builder().description("Trafik piyadesi").answer("yaya").build(),
				SaveQuestionRequest.builder().description("Orta çağ'da nüfusun yaklaşık üçte birini yok eden hastalık").answer("veba").build(),
				SaveQuestionRequest.builder().description("Bir yemeğin yapılmasında kullanılan ve tat veren maddelerin bütünü").answer("harç").build(),
				SaveQuestionRequest.builder().description("Yardım isteğini, ricayı, af talebini, beğeniyi, şaşkınlığı, usanç ve bıkkınlığı anlatan bir söz").answer("aman").build(),
				SaveQuestionRequest.builder().description("Satrançta ROK işleminde şahı korumaya alan taş").answer("kale").build(),
				SaveQuestionRequest.builder().description("Bilgin anlamında arapça kökenli söz").answer("alim").build(),
				SaveQuestionRequest.builder().description("Olmuş, olan anlamlarında arapça kökenli bir söz").answer("vaki").build(),
				SaveQuestionRequest.builder().description("Günindi, garp, muğrip isimleriyle de anılan ana yön").answer("batı").build(),
				SaveQuestionRequest.builder().description("Hakkak da denen zanaatkarın ahşaba yaptığı süs").answer("oyma").build(),
				SaveQuestionRequest.builder().description("Yöresel amca").answer("emmi").build(),


				SaveQuestionRequest.builder().description("Birden ortaya çıkan, aşırı ve normalin dışına taşmış korku hali").answer("panik").build(),
				SaveQuestionRequest.builder().description("Fransızca kökenli zarif kibar anlamındaki söz").answer("janti").build(),
				SaveQuestionRequest.builder().description("Beden, boy, pos anlamında kullanılan sözcük").answer("endam").build(),
				SaveQuestionRequest.builder().description("Eskiden yüksek makamdaki kadınlara ve hakan eşlerine verilen unvan").answer("hatun").build(),
				SaveQuestionRequest.builder().description("Sabahın güneş doğmadan önceki zamanı").answer("seher").build(),
				SaveQuestionRequest.builder().description("Açısal momentum kebabı").answer("döner").build(),
				SaveQuestionRequest.builder().description("Kolu savurarak atılan kudretli tokat").answer("sille").build(),
				SaveQuestionRequest.builder().description("Sebebi anlatırken kullanılan bir bağlaç").answer("çünkü").build(),
				SaveQuestionRequest.builder().description("Göğün en yüksek yeri").answer("ayyuk").build(),
				SaveQuestionRequest.builder().description("Yapılacak bir hizmet veya satın alınacak bir mal için anlaşmaya göre önceden ödenen miktar").answer("avans").build(),
				SaveQuestionRequest.builder().description("Sünnet sponsoru").answer("kirve").build(),
				SaveQuestionRequest.builder().description("Bir çemberin içinde kalan düzlem parçası").answer("daire").build(),
				SaveQuestionRequest.builder().description("Eski zamanlarda kullanılan düz yakalı, önü ilikli bir tür erkek ceketi").answer("setre").build(),
				SaveQuestionRequest.builder().description("İskoç milli çalgısı").answer("gayda").build(),
				SaveQuestionRequest.builder().description("Lekeler bırakılarak boyanmış kumaş").answer("batik").build(),
				SaveQuestionRequest.builder().description("Karo onlunun üç, sinek ikilinin iki, asların ve valelerin birer puan sayıldığı iskambil oyunu").answer("pişti").build(),
				SaveQuestionRequest.builder().description("Bedeli teslimattan önce veya teslimatla birlikte ödenen").answer("peşin").build(),
				SaveQuestionRequest.builder().description("Mecazen, önemini güncelliğini yitirmiş olan haber veya esprileri niteleyen sıfat").answer("bayat").build(),
				SaveQuestionRequest.builder().description("Eksiklik, kusur ayıp ve hile kir leke anlamlarında eski bir sözcük").answer("şaibe").build(),


				SaveQuestionRequest.builder().description("Futbolda hem orta yuvarlak hem başlama vuruşu anlamlarına gelen söz").answer("santra").build(),
				SaveQuestionRequest.builder().description("Cevabı şehvet olan olan seksüel şevk sorusuna verilen yanıt").answer("behlül").build(),
				SaveQuestionRequest.builder().description("Çıplaklıktan yana olan").answer("nüdist").build(),
				SaveQuestionRequest.builder().description("Toplumsal beğeniyi ve yeni olma vasfını kaybetmiş olan").answer("demode").build(),
				SaveQuestionRequest.builder().description("Boyar maddelerin katı bir hamur olana kadar karıştırılmasıyla elde edilen çubuk biçimindeki boya").answer("pastel").build(),
				SaveQuestionRequest.builder().description("İlahi sigorta primi").answer("sadaka").build(),
				SaveQuestionRequest.builder().description("Gakkoşlar diyarı").answer("elazığ").build(),
				SaveQuestionRequest.builder().description("Dargın sözünün eş anlamlısı").answer("küskün").build(),
				SaveQuestionRequest.builder().description("Küçük bir maşa biçimindeki kıstırma gereci").answer("cımbız").build(),
				SaveQuestionRequest.builder().description("Uygun zaman, uygun durum ve şart").answer("fırsat").build(),
				SaveQuestionRequest.builder().description("Toplumsal yaşantıdan kaçış").answer("inziva").build(),
				SaveQuestionRequest.builder().description("Dokundurmak, değdirmek veya bir yüzey üzerine ince bir tabaka olarak yaymak, dökmek, serpmek anlamlarında kullanılan söz").answer("sürmek").build(),
				SaveQuestionRequest.builder().description("Herhangi bir yerin dağlarını, ovalarını, platolarını, akarsularını, göllerini gösteren haritaların ön adı").answer("fiziki").build(),
				SaveQuestionRequest.builder().description("Küçük, ağır bir top ve sopalarla onbirer kişilik takımlar arasında oynanan bir oyun").answer("kriket").build(),
				SaveQuestionRequest.builder().description("Çift başlı figürü Mezapotamya, Anadolu, İran, Avrupa, Amerika hatta Uzak Doğu'da bile kullanılmış olan hayvan").answer("kartal").build(),
				SaveQuestionRequest.builder().description("Eski bayramlarda hediye olarak verilen kişisel temizlik gereci").answer("mendil").build(),


				SaveQuestionRequest.builder().description("Genellikle viyol denen özel karton kaplarda satılan, kendinden ambalajlı bir besin").answer("yumurta").build(),
				SaveQuestionRequest.builder().description("Çiçekler aleminin havuz güzeli").answer("nilüfer").build(),
				SaveQuestionRequest.builder().description("Kendi adına kazanç sağlanan tüm meslek türlerini niteleyen bir söz").answer("serbest").build(),
				SaveQuestionRequest.builder().description("Belgesel filmlerde gariban rolünde olan yardımcı oyuncu").answer("antilop").build(),
				SaveQuestionRequest.builder().description("Çok konuşarak karşısındakini paralize eden kişi").answer("çenebaz").build(),
				SaveQuestionRequest.builder().description("Kavramsal tutarsızlık, paradoks").answer("çelişki").build(),
				SaveQuestionRequest.builder().description("Yasadışı kazancı temize çıkarmak").answer("aklamak").build(),
				SaveQuestionRequest.builder().description("Güzeli çirkinden ayırma yoksunu").answer("zevksiz").build(),
				SaveQuestionRequest.builder().description("Gizemli tahmin").answer("kehanet").build(),
				SaveQuestionRequest.builder().description("Kimsesiz ve zavallı anlamında Arapça-Farsça karışımı bir sözcük ").answer("gariban").build(),
				SaveQuestionRequest.builder().description("Hayatını feda edecek kadar anlamında bir söz").answer("ölesiye").build(),
				SaveQuestionRequest.builder().description("Kıyma, soğan, sarımsak ve domatesle hazırlanan bir sos").answer("bolonez").build(),
				SaveQuestionRequest.builder().description("Tadımlık seyahat").answer("gezinti").build(),
				SaveQuestionRequest.builder().description("Futbolun rus ruleti").answer("penaltı").build(),
				SaveQuestionRequest.builder().description("Hukukta sözleşme anlamında kullanılan Fransızca kökenli sözcük").answer("kontrat").build(),
				SaveQuestionRequest.builder().description("Hava indirme gereci").answer("paraşüt").build(),
				SaveQuestionRequest.builder().description("İki kişinin kanunlarların uygun gördüğü şekilde ruhen ve bedenen bir araya gelmesi").answer("evlilik").build(),
				SaveQuestionRequest.builder().description("Letafet sözcüğünün günümüz türkçesindeki karşılıklarından biri").answer("incelik").build(),


				SaveQuestionRequest.builder().description("Takım çalışmalarında ekip elemanlarının sorumluluk ve yükümlülükleri paylaşması").answer("işbölümü").build(),
				SaveQuestionRequest.builder().description("Durum, ortam, çevre, atmosfer anlamlarında kullanılan bir sözcük").answer("ambiyans").build(),
				SaveQuestionRequest.builder().description("Ultraviyole sözcüğünün Türkçe karşılığı").answer("morötesi").build(),
				SaveQuestionRequest.builder().description("Bibliyografya sözünün Türkçe kökenli karşılığı").answer("kaynakça").build(),
				SaveQuestionRequest.builder().description("Motorlar için kesik kesik çalışmak anlamında kullanılan bir söz").answer("teklemek").build(),
				SaveQuestionRequest.builder().description("Yaşam kıvılcımıyla laboratuar ortamında karşılaşan insan yavrusu").answer("tüpbebek").build(),
				SaveQuestionRequest.builder().description("Mecazi anlamda fena halde azarlamak").answer("haşlamak").build(),
				SaveQuestionRequest.builder().description("Elindekileri içtenlikle paylaşan, cömert").answer("gönlübol").build(),
				SaveQuestionRequest.builder().description("Birinin iyi niyetini kötüye kullanma, sömürme anlamındaki Arapça kökenli söz").answer("istismar").build(),
				SaveQuestionRequest.builder().description("Fransızca kökenli oportunist kelimesinin Türkçe karşılığı").answer("fırsatçı").build(),
				SaveQuestionRequest.builder().description("Toprak küskünlüğü").answer("kuraklık").build(),
				SaveQuestionRequest.builder().description("Resmi dili Urduca olan ülke").answer("pakistan").build(),
				SaveQuestionRequest.builder().description("Araları açılmak").answer("bozuşmak").build(),
				SaveQuestionRequest.builder().description("Rasat dürbünü").answer("teleskop").build(),
				SaveQuestionRequest.builder().description("Basketboldaki kapkaç").answer("topçalma").build(),
				SaveQuestionRequest.builder().description("Polenlerin hava, su veya böceklerle dağılıp başka çiçeklere ulaşması").answer("tozlaşma").build(),
				SaveQuestionRequest.builder().description("Bir şeyi azar azar başka bir şeyin içine karıştırarak belli olmayacak duruma getirmek").answer("yedirmek").build(),
				SaveQuestionRequest.builder().description("Etmek fiiliyle birlikte ilgilendirmek anlamında kullanılan Fransızca kökenli bir söz").answer("enterese").build(),
				SaveQuestionRequest.builder().description("Sesli yanıt sistemiyle yapılan görüşmelerde karşımıza çıkan gerçek insan").answer("operatör").build(),


				SaveQuestionRequest.builder().description("Bahane veya kusur bulma anlamında bir deyim").answer("kulptakma").build(),
				SaveQuestionRequest.builder().description("İlk ve acil yardım, acil tıp teknisyeni anlamlarında kullanılan yabancı kökenli bir terim").answer("paramedik").build(),
				SaveQuestionRequest.builder().description("Yağmur, kar gibi doğa olayları için “Birdenbire başlamak, etkili olmak” anlamında kullanılan bir söz").answer("bastırmak").build(),
				SaveQuestionRequest.builder().description("Mobilya sektörünün yeniyetmelere yönelik hazırladığı renk cümbüşü bütünü").answer("gençodası").build(),
				SaveQuestionRequest.builder().description("Herhangi bir iş veya olayın, belirlenmiş süresinin sonunu heyecanla beklemek").answer("günsaymak").build(),
				SaveQuestionRequest.builder().description("Pervasızca, sonunu düşünmeden ileriye atılmak").answer("bodoslama").build(),
				SaveQuestionRequest.builder().description("Mecazi anlamda büyük fayda ve çıkar sağlanan yer").answer("yağlıkapı").build(),
				SaveQuestionRequest.builder().description("Destek ve beğeni gösterisi").answer("tezahürat").build(),
				SaveQuestionRequest.builder().description("Erotik köfte").answer("kadınbudu").build(),
				SaveQuestionRequest.builder().description("Önemi yok, etkisi olmaz, değişmez anlamlarına gelen bir söz dizisi").answer("farketmez").build(),
				SaveQuestionRequest.builder().description("Özellikle Karadeniz bölgesinde doğal olarak yetişen bir ağacın ve siyah renkteki meyvenin adı").answer("karayemiş").build(),
				SaveQuestionRequest.builder().description("Önemsemeye, üzülmeye değmez anlamında bir tabir").answer("dertdeğil").build(),
				SaveQuestionRequest.builder().description("Sırayla belirli zaman aralıklarında değişerek anlamındaki söz").answer("nöbetleşe").build(),
				SaveQuestionRequest.builder().description("Bir şeyi tutmak, kavramak istemek").answer("eligitmek").build(),
				SaveQuestionRequest.builder().description("Observatuvar ve gözlemevi sözlerinin karşılığı").answer("rasathane").build(),
				SaveQuestionRequest.builder().description("Ciddi bir şeye espri görünümü vererek anlamındaki söz dizisi").answer("şakayollu").build(),
				SaveQuestionRequest.builder().description("Bir sözün doğruluğuna inandırmak için kullanılan, Allah bilir anlamındaki tabir").answer("alimallah").build(),


				SaveQuestionRequest.builder().description("Özü ve içeriği önemsemeden, dış görünüşe ağırlık veren görüş").answer("şekilcilik").build(),
				SaveQuestionRequest.builder().description("Utanılacak duruma düşme, alay konusu haline gelme").answer("kepazeolma").build(),
				SaveQuestionRequest.builder().description("İnternet ortamının kutsal bilgi kaynağı nedir?").answer("ekşisözlük").build(),
				SaveQuestionRequest.builder().description("Artik kulanilmayan en yuksek dereceli akademik unvan").answer("ordinaryus").build(),
				SaveQuestionRequest.builder().description("Surat ve mimiklerdeki anlatım").answer("yüzifadesi").build(),
				SaveQuestionRequest.builder().description("Herhangi bir kişi veya bir durum için çok masraf yapmak").answer("paradökmek").build(),
				SaveQuestionRequest.builder().description("Düzeltmek amacıyla küçük değişiklikler yapmak").answer("rötuşlamak").build(),
				SaveQuestionRequest.builder().description("Tütünün tiryakisi olmadan kurbanı olan kişi, edilgin tüketici").answer("pasifiçici").build(),
				SaveQuestionRequest.builder().description("Kızma öfkelenme anlamında bir sözcük").answer("celallenme").build(),
				SaveQuestionRequest.builder().description("Soğuğa sıcak, sıcağa soğuk katmak veya hafif ısıtmak").answer("ılıştırmak").build(),
				SaveQuestionRequest.builder().description("Genellikle tatil sabahları, yeni uyanmışken sürülen sefa").answer("yatakkeyfi").build(),
				SaveQuestionRequest.builder().description("Mecazen cilveli, oynak anlamında bir ikileme").answer("fıkırfıkır").build(),
				SaveQuestionRequest.builder().description("Sanayide kullanılan kahve, kakao, kauçuk gibi bazı bitkilerin geniş ölçüde yetiştirildiği işletme").answer("plantasyon").build()
		);

		for (int i = 0; i < questions.size(); i++) {
			questionService.saveQuestion(questions.get(i));
		}
	}
}
