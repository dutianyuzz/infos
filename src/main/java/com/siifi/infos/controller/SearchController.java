package com.siifi.infos.controller;

import com.siifi.infos.entity.Product;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "infos")
public class SearchController {
    @Autowired
    private SolrClient solrClient;


    @RequestMapping("/search.html")
    public String searchs() {
        return "search";
    }
    /**
     * 综合查询: 在综合查询中, 有按条件查询, 条件过滤, 排序, 分页, 高亮显示, 获取部分域信息
     *
     * @return
     */
    @RequestMapping(value = "search", method = RequestMethod.GET)
    @ResponseBody
    public List<Product> search(@RequestParam(value="name") String name/*,@RequestParam(value="pageNum") Integer pageNum,@RequestParam(value="pageSize") Integer pageSize*/) {
        try {
            SolrQuery solrQuery = new SolrQuery();
            //查询条件, 这里的 q 对应 下面图片标红的地方
            solrQuery.setQuery(name);
            //分页
/*            solrQuery.setStart(pageNum);
            solrQuery.setRows(pageSize);*/
            //默认域
            solrQuery.set("df", "product_keywords");
            //只查询指定域  查询内容
            solrQuery.set("fl", "id,p_name,p_imagePath,product_keywords,p_date,p_utter");

/*            //高亮
            //打开开关
            solrQuery.setHighlight(true);
            //指定高亮域
            solrQuery.addHighlightField("p_name");
            //设置前缀
            solrQuery.setHighlightSimplePre("<span style='color:red'>");
            //设置后缀
            solrQuery.setHighlightSimplePost("</span>");*/
            // 执行查询
            QueryResponse queryResponse = solrClient.query(solrQuery);
            // 文档结果集
            SolrDocumentList results = queryResponse.getResults();

            long numFound = results.getNumFound();
            System.out.println(numFound);  //查询条数

/*            Map<String, Map<String, List<String>>> highlight = queryResponse.getHighlighting();*/
            List<Product> products = new ArrayList<>();
            for (SolrDocument result : results) {
                Product product=new Product();
                product.setProductName((String)result.get("p_name"));
                product.setImagePath((String)result.get("p_imagePath"));
/*                Map<String, List<String>> map = highlight.get(result.get("id"));
                List<String> list = map.get("p_name");
                product.setProductName(list.get(0));*/

                products.add(product);
            }
            return products;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

