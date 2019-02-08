/**
 * Provides all database classes related to the catalogue. A catalogue can be seen as the top-level object of a
 * collection. Since database tables are mapped onto Java classes, we will speak of classes as a synonym of db tables<br/>
 * <ul>
 *  <li>Catalogue class gathers information on the <i>corpora</i>, <i>authors</i> and so on;</li>
 *  <li>CataloguePadding class contains information on the padding to be applied to the block id, in order to reconstruct it
 * later;</li>
 * <li>CatalogueMetainfo class gathers all catalogue metadata;</li>
 * <li>CatalogueObject class represents a single object of the catalogue, eg. a digital edition of a work</li>
 * <li>CatalogueRelationships class sets the relationships between a catalogue instance and another one: eg. the former
 * might be the parent of the latter. There's a top-level parent, which is the root of all other relationships for that
 * catalogue</li>
 * </ul>
 */
package euporia.database.catalogues;