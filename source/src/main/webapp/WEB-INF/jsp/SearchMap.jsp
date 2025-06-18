<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8" />
  <title>J-SHIS地震ハザードマップ重ね表示（ラジオボタン切り替え）</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">

  <link rel="stylesheet" href="https://unpkg.com/leaflet@1.7.1/dist/leaflet.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/homemap.css">
  <script src="https://unpkg.com/leaflet@1.7.1/dist/leaflet.js"></script>

  <style>
    html, body {
      height: 100%;
      margin: 0;
    }
    #map {
      width: 100%;
      height: 100vh;
    }
    .layer-control {
      position: absolute;
      top: 10px;
      left: 10px;
      z-index: 1000;
      background: white;
      padding: 10px;
      border-radius: 5px;
      box-shadow: 0 0 6px rgba(0,0,0,0.3);
      font-size: 14px;
    }
    .layer-control label {
      display: block;
      margin-bottom: 5px;
    }
    
    #example-text img {
    width:200px;
    height:200px;
    z-index: 1000;
    }
  </style>
</head>

<body>

<header>
	<div class= "logo-header">
		<a href="${pageContext.request.contextPath}/home">
		<img src="${pageContext.request.contextPath}/img/logo.png">
		</a>
	</div>
</header>

<h1>ハザードマップ</h1>
<div id="example-text">
<p id="description" >ここに説明文が表示されます</p>
</div>
  <div id="map"></div>

  <div class="layer-control" style="margin-left: 1250px;margin-top:150px;">
    <strong>災害レイヤー選択</strong>
    <label><input type="radio" name="hazard" value="shinsui" checked> 洪水</label>
    <label><input type="radio" name="hazard" value="takashio"> 高潮</label>
    <label><input type="radio" name="hazard" value="tsunami"> 津波</label>
    <label><input type="radio" name="hazard" value="doseki"> 土砂</label>
    <label><input type="radio" name="hazard" value="nadare"> 雪崩</label>
    <label><input type="radio" name="hazard" value="jshis_I45"> 地震（震度5弱以上）</label>
    <label><input type="radio" name="hazard" value="jshis_I55"> 地震（震度6弱以上）</label>
  </div>

  <script>
    var tiri = L.tileLayer('https://cyberjapandata.gsi.go.jp/xyz/pale/{z}/{x}/{y}.png', {
      attribution: '&copy; <a href="http://maps.gsi.go.jp/development/ichiran.html" target="_blank">地理院タイル</a>'
    });

    var opacitySetting = { opacity: 0.6 };

    var layers = {
      shinsui: L.tileLayer('https://disaportaldata.gsi.go.jp/raster/01_flood_l2_shinsuishin_kuni_data/{z}/{x}/{y}.png', opacitySetting),
      takashio: L.tileLayer('https://disaportaldata.gsi.go.jp/raster/03_hightide_l2_shinsuishin_data/{z}/{x}/{y}.png', opacitySetting),
      tsunami: L.tileLayer('https://disaportaldata.gsi.go.jp/raster/04_tsunami_newlegend_data/{z}/{x}/{y}.png', opacitySetting),
      doseki: L.tileLayer('https://disaportaldata.gsi.go.jp/raster/05_dosekiryukeikaikuiki/{z}/{x}/{y}.png', opacitySetting),
      nadare: L.tileLayer('https://disaportaldata.gsi.go.jp/raster/05_nadarekikenkasyo/{z}/{x}/{y}.png', opacitySetting),
      jshis_I45: L.tileLayer.wms("https://www.j-shis.bosai.go.jp/map/wms/pshm/Y2020", {
        layers: 'P-Y2020-MAP-MAX-TTL_MTTL-T30_I45_PS',
        format: 'image/png',
        transparent: true,
        version: '1.3.0',
        attribution: '&copy; J-SHIS 地震ハザードステーション',
        opacity: 0.6
      }),
      jshis_I55: L.tileLayer.wms("https://www.j-shis.bosai.go.jp/map/wms/pshm/Y2020", {
        layers: 'P-Y2020-MAP-AVR-TTL_MTTL-T30_I55_PS',
        format: 'image/png',
        transparent: true,
        version: '1.3.0',
        attribution: '&copy; J-SHIS 地震ハザードステーション',
        opacity: 0.6
      })
    };

    var currentLayer = layers["shinsui"];

    var map = L.map('map', {
      center: [35.681236, 139.767125],
      zoom: 10,
      layers: [tiri, currentLayer]
    });

    // ラジオボタン切り替え処理
    document.querySelectorAll('input[name="hazard"]').forEach(function (input) {
      input.addEventListener('change', function () {
        if (currentLayer) {
          map.removeLayer(currentLayer);
        }
        currentLayer = layers[this.value];
        map.addLayer(currentLayer);
      });
    });
  </script>
      <script>
        document.querySelectorAll('input[name="hazard"]').forEach(radio => {
            radio.addEventListener('change', function() {
                const description = document.getElementById('description');
                switch (this.value) {
                    case 'shinsui':
                        description.innerHTML='<p>これはテストです。</p><img src="${pageContext.request.contextPath}/img/example.png" >';
                        break;
                    case 'takashio':
                        description.textContent = '選択肢2の説明です。';
                        break;
                    case 'tunami':
                        description.textContent = '選択肢3の説明です。';
                        break;
                    default:
                        description.textContent = '選択肢が選ばれていません。';
                }
            });
        });
    </script>
</body>
</html>